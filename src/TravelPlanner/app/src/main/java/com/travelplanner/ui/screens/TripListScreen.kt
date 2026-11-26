package com.travelplanner.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.travelplanner.data.Trip
import com.travelplanner.ui.TripViewModel
import com.travelplanner.ui.formatDate
import com.travelplanner.ui.travelersLabel
import java.time.LocalDate
import java.time.temporal.ChronoUnit

// FR-1.5: all trips, upcoming first (soonest at the top), then past trips.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripListScreen(
    viewModel: TripViewModel,
    onAddTrip: () -> Unit,
    onOpenTrip: (String) -> Unit
) {
    val trips by viewModel.trips.collectAsState()
    val today = LocalDate.now().toString()
    val (upcoming, past) = trips.partition { it.endDate >= today }
    val sortedTrips = upcoming.sortedBy { it.startDate } + past.sortedByDescending { it.startDate }

    Scaffold(
        topBar = { TopAppBar(title = { Text("My trips") }) },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onAddTrip,
                icon = { Icon(Icons.Default.Add, contentDescription = null) },
                text = { Text("New trip") }
            )
        }
    ) { padding ->
        if (sortedTrips.isEmpty()) {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "No trips yet. Tap New trip to plan your first one.",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 96.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(sortedTrips, key = { it.id }) { trip ->
                    TripCard(trip = trip, onClick = { onOpenTrip(trip.id) })
                }
            }
        }
    }
}

@Composable
private fun TripCard(trip: Trip, onClick: () -> Unit) {
    val today = LocalDate.now()
    val start = LocalDate.parse(trip.startDate)
    val end = LocalDate.parse(trip.endDate)
    val status = when {
        today.isAfter(end) -> "Past trip"
        today.isBefore(start) -> {
            val days = ChronoUnit.DAYS.between(today, start)
            if (days == 1L) "Tomorrow" else "In $days days"
        }
        else -> "Happening now"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(status, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
            Text(trip.name, style = MaterialTheme.typography.titleLarge)
            Text(trip.destination, style = MaterialTheme.typography.bodyLarge)
            Text(
                "${formatDate(trip.startDate)} – ${formatDate(trip.endDate)} · ${travelersLabel(trip.travelers)}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
