package com.travelplanner.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.travelplanner.data.Activity
import com.travelplanner.ui.TripViewModel
import com.travelplanner.ui.components.DateField
import com.travelplanner.ui.components.errorText
import com.travelplanner.ui.components.TimeField
import com.travelplanner.ui.formatDate
import java.util.UUID

// FR-2.1, FR-2.2 and FR-2.4: add an activity (activityId == null) or edit one.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityFormScreen(
    viewModel: TripViewModel,
    tripId: String,
    activityId: String?,
    onDone: () -> Unit
) {
    val trip = remember(tripId) { viewModel.getTrip(tripId) } ?: return
    val existing = remember(activityId) { activityId?.let { id -> trip.activities.find { it.id == id } } }

    var title by rememberSaveable { mutableStateOf(existing?.title ?: "") }
    var date by rememberSaveable { mutableStateOf(existing?.date ?: trip.startDate) }
    var startTime by rememberSaveable { mutableStateOf(existing?.startTime ?: "") }
    var endTime by rememberSaveable { mutableStateOf(existing?.endTime ?: "") }
    var location by rememberSaveable { mutableStateOf(existing?.location ?: "") }
    var notes by rememberSaveable { mutableStateOf(existing?.notes ?: "") }
    var errors by remember { mutableStateOf(mapOf<String, String>()) }

    fun save() {
        val found = mutableMapOf<String, String>()
        if (title.isBlank()) found["title"] = "Enter a title"
        if (date < trip.startDate || date > trip.endDate) {
            found["date"] = "Pick a date between ${formatDate(trip.startDate)} and ${formatDate(trip.endDate)}"
        }
        if (startTime.isEmpty()) found["start"] = "Pick a start time"
        if (endTime.isNotEmpty() && startTime.isNotEmpty() && endTime <= startTime) {
            found["end"] = "End time must be after the start time"
        }

        errors = found
        if (found.isNotEmpty()) return

        viewModel.saveActivity(
            tripId,
            Activity(
                id = existing?.id ?: UUID.randomUUID().toString(),
                title = title.trim(),
                date = date,
                startTime = startTime,
                endTime = endTime.ifEmpty { null },
                location = location.trim(),
                notes = notes.trim()
            )
        )
        onDone()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (existing == null) "Add activity" else "Edit activity") },
                navigationIcon = {
                    IconButton(onClick = onDone) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .imePadding()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                singleLine = true,
                isError = errors.containsKey("title"),
                supportingText = errorText(errors["title"]),
                modifier = Modifier.fillMaxWidth()
            )
            DateField(
                label = "Date",
                value = date,
                onValueChange = { date = it },
                error = errors["date"]
            )
            TimeField(
                label = "Start time",
                value = startTime,
                onValueChange = { startTime = it },
                error = errors["start"]
            )
            TimeField(
                label = "End time (optional)",
                value = endTime,
                onValueChange = { endTime = it },
                error = errors["end"]
            )
            if (endTime.isNotEmpty()) {
                TextButton(onClick = { endTime = "" }) { Text("Clear end time") }
            }
            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Location (optional)") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = notes,
                onValueChange = { notes = it },
                label = { Text("Notes (optional)") },
                minLines = 3,
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { save() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(if (existing == null) "Add activity" else "Save changes")
            }
        }
    }
}
