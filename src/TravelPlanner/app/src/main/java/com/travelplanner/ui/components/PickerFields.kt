package com.travelplanner.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.travelplanner.ui.formatDate
import com.travelplanner.ui.formatTime
import com.travelplanner.ui.isoDateToMillis
import com.travelplanner.ui.millisToIsoDate
import java.time.LocalTime
import java.util.Locale

// A read-only text field that opens a calendar when tapped. value is "yyyy-MM-dd" or "".
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    error: String?,
    modifier: Modifier = Modifier
) {
    var showPicker by remember { mutableStateOf(false) }

    Box(modifier) {
        OutlinedTextField(
            value = if (value.isEmpty()) "" else formatDate(value),
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            isError = error != null,
            supportingText = errorText(error),
            modifier = Modifier.fillMaxWidth()
        )
        // Invisible layer on top of the field so a tap opens the picker.
        Box(
            Modifier
                .matchParentSize()
                .clickable { showPicker = true }
        )
    }

    if (showPicker) {
        val state = rememberDatePickerState(
            initialSelectedDateMillis = if (value.isEmpty()) null else isoDateToMillis(value)
        )
        DatePickerDialog(
            onDismissRequest = { showPicker = false },
            confirmButton = {
                TextButton(onClick = {
                    state.selectedDateMillis?.let { onValueChange(millisToIsoDate(it)) }
                    showPicker = false
                }) { Text("OK") }
            },
            dismissButton = {
                TextButton(onClick = { showPicker = false }) { Text("Cancel") }
            }
        ) {
            DatePicker(state = state)
        }
    }
}

// A read-only text field that opens a clock when tapped. value is "HH:mm" or "".
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    error: String?,
    modifier: Modifier = Modifier
) {
    var showPicker by remember { mutableStateOf(false) }

    Box(modifier) {
        OutlinedTextField(
            value = if (value.isEmpty()) "" else formatTime(value),
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            isError = error != null,
            supportingText = errorText(error),
            modifier = Modifier.fillMaxWidth()
        )
        Box(
            Modifier
                .matchParentSize()
                .clickable { showPicker = true }
        )
    }

    if (showPicker) {
        val initial = if (value.isEmpty()) LocalTime.of(9, 0) else LocalTime.parse(value)
        val state = rememberTimePickerState(
            initialHour = initial.hour,
            initialMinute = initial.minute
        )
        AlertDialog(
            onDismissRequest = { showPicker = false },
            confirmButton = {
                TextButton(onClick = {
                    onValueChange(String.format(Locale.US, "%02d:%02d", state.hour, state.minute))
                    showPicker = false
                }) { Text("OK") }
            },
            dismissButton = {
                TextButton(onClick = { showPicker = false }) { Text("Cancel") }
            },
            text = { TimePicker(state = state) }
        )
    }
}

// Shows a field's error message under it, or nothing when there's no error (NFR-3).
fun errorText(message: String?): (@Composable () -> Unit)? {
    if (message == null) return null
    return { Text(message) }
}
