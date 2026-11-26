package com.travelplanner.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.travelplanner.data.Activity
import com.travelplanner.data.Trip
import com.travelplanner.ui.TripViewModel
import com.travelplanner.ui.formatDate
import com.travelplanner.ui.formatTime
import com.travelplanner.ui.travelersLabel
import java.time.LocalDate
import java.time.temporal.ChronoUnit

// Trip details plus its itinerary, grouped by day and sorted by start time (FR-2.3).
// Edit and delete the trip from the top bar (FR-1.3, FR-1.4).
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripDetailScreen(
    viewModel: TripViewModel,
    tripId: String,
    onBack: () -> Unit,
    onEditTrip: () -> Unit,
    onAddActivity: () -> Unit,
    onEditActivity: (String) -> Unit
) {
    val trips by viewModel.trips.collectAsState()
    var showDeleteDialog by remember { mutableStateOf(false) }
    val trip = trips.find { it.id == tripId } ?: return

    val days = trip.activities
        .sortedWith(compareBy({ it.date }, { it.startTime }))
        .groupBy { it.date }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(trip.name, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onEditTrip) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit trip")
                    }
                    IconButton(onClick = { showDeleteDialog = true }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete trip")
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onAddActivity,
                icon = { Icon(Icons.Default.Add, contentDescription = null) },
                text = { Text("Add activity") }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 96.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { TripSummaryCard(trip) }
            item {
                Text(
                    "Itinerary",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            if (days.isEmpty()) {
                item {
                    Text(
                        "No activities yet. Tap Add activity to plan your first day.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            days.forEach { (date, activities) ->
                item(key = "day-$date") { DayHeader(trip, date) }
                items(activities, key = { it.id }) { activity ->
                    ActivityRow(
                        activity = activity,
                        onClick = { onEditActivity(activity.id) },
                        onDelete = { viewModel.deleteActivity(trip.id, activity.id) }
                    )
                }
            }
        }
    }

    if (showDeleteDialog) {
        AlertDialog(
            onDismissRequest = { showDeleteDialog = false },
            title = { Text("Delete this trip?") },
            text = { Text("\"${trip.name}\" and its whole itinerary will be removed. This can't be undone.") },
            confirmButton = {
                TextButton(onClick = {
                    showDeleteDialog = false
                    onBack()
                    viewModel.deleteTrip(trip.id)
                }) { Text("Delete") }
            },
            dismissButton = {
                TextButton(onClick = { showDeleteDialog = false }) { Text("Cancel") }
            }
        )
    }
}

@Composable
private fun TripSummaryCard(trip: Trip) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(trip.destination, style = MaterialTheme.typography.headlineSmall)
            Text("${formatDate(trip.startDate)} – ${formatDate(trip.endDate)}")
            Text(travelersLabel(trip.travelers))
            if (trip.description.isNotBlank()) {
                Text(trip.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Composable
private fun DayHeader(trip: Trip, date: String) {
    val dayNumber = ChronoUnit.DAYS.between(LocalDate.parse(trip.startDate), LocalDate.parse(date)) + 1
    Text(
        "Day $dayNumber · ${formatDate(date)}",
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(top = 12.dp)
    )
}

@Composable
private fun ActivityRow(activity: Activity, onClick: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 12.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.width(80.dp)) {
                Text(formatTime(activity.startTime), style = MaterialTheme.typography.labelLarge)
                activity.endTime?.let {
                    Text(
                        formatTime(it),
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            Column(Modifier.weight(1f)) {
                Text(activity.title, style = MaterialTheme.typography.titleMedium)
                if (activity.location.isNotBlank()) {
                    Text(
                        activity.location,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                if (activity.notes.isNotBlank()) {
                    Text(
                        activity.notes,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = "Delete activity")
            }
        }
    }
}
