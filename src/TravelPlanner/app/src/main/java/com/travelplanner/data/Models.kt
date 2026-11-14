package com.travelplanner.data

import kotlinx.serialization.Serializable
import java.util.UUID

// One planned activity inside a trip (FR-2.1).
// Dates are stored as "yyyy-MM-dd" and times as "HH:mm" so they sort correctly as text.
@Serializable
data class Activity(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val date: String,
    val startTime: String,
    val endTime: String? = null,
    val location: String = "",
    val notes: String = ""
)

// A trip and everything planned for it (FR-1.1).
@Serializable
data class Trip(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val destination: String,
    val startDate: String,
    val endDate: String,
    val travelers: Int,
    val description: String = "",
    val activities: List<Activity> = emptyList()
)
