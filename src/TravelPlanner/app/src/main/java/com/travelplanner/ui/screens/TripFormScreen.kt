package com.travelplanner.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.travelplanner.data.Trip
import com.travelplanner.ui.TripViewModel
import com.travelplanner.ui.components.DateField
import com.travelplanner.ui.components.errorText

// FR-1.1, FR-1.2 and FR-1.3: create a trip (tripId == null) or edit one.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripFormScreen(
    viewModel: TripViewModel,
    tripId: String?,
    onDone: () -> Unit
) {
    val existing = remember(tripId) { tripId?.let { viewModel.getTrip(it) } }

    var name by rememberSaveable { mutableStateOf(existing?.name ?: "") }
    var destination by rememberSaveable { mutableStateOf(existing?.destination ?: "") }
    var startDate by rememberSaveable { mutableStateOf(existing?.startDate ?: "") }
    var endDate by rememberSaveable { mutableStateOf(existing?.endDate ?: "") }
    var travelers by rememberSaveable { mutableStateOf(existing?.travelers?.toString() ?: "1") }
    var description by rememberSaveable { mutableStateOf(existing?.description ?: "") }
    var errors by remember { mutableStateOf(mapOf<String, String>()) }

    fun save() {
        val found = mutableMapOf<String, String>()
        if (name.isBlank()) found["name"] = "Enter a trip name"
        else if (name.trim().length > 48) found["name"] = "Use 48 characters or fewer"
        if (destination.isBlank()) found["destination"] = "Enter a destination"
        if (startDate.isEmpty()) found["start"] = "Pick a start date"
        if (endDate.isEmpty()) found["end"] = "Pick an end date"
        else if (startDate.isNotEmpty() && endDate < startDate) found["end"] = "End date can't be before the start date"
        val count = travelers.toIntOrNull()
        if (count == null || count < 1) found["travelers"] = "Enter at least 1 traveler"

        errors = found
        if (found.isNotEmpty()) return

        val base = existing ?: Trip(name = "", destination = "", startDate = "", endDate = "", travelers = 1)
        viewModel.saveTrip(
            base.copy(
                name = name.trim(),
                destination = destination.trim(),
                startDate = startDate,
                endDate = endDate,
                travelers = count ?: 1,
                description = description.trim()
            )
        )
        onDone()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (existing == null) "New trip" else "Edit trip") },
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
                value = name,
                onValueChange = { name = it },
                label = { Text("Trip name") },
                singleLine = true,
                isError = errors.containsKey("name"),
                supportingText = { Text(errors["name"] ?: "${name.length}/48") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = destination,
                onValueChange = { destination = it },
                label = { Text("Main destination") },
                singleLine = true,
                isError = errors.containsKey("destination"),
                supportingText = errorText(errors["destination"]),
                modifier = Modifier.fillMaxWidth()
            )
            DateField(
                label = "Start date",
                value = startDate,
                onValueChange = { startDate = it },
                error = errors["start"]
            )
            DateField(
                label = "End date",
                value = endDate,
                onValueChange = { endDate = it },
                error = errors["end"]
            )
            OutlinedTextField(
                value = travelers,
                onValueChange = { travelers = it.filter { c -> c.isDigit() } },
                label = { Text("Number of travelers") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = errors.containsKey("travelers"),
                supportingText = errorText(errors["travelers"]),
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description (optional)") },
                minLines = 3,
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { save() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text(if (existing == null) "Create trip" else "Save changes")
            }
        }
    }
}
