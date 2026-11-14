package com.travelplanner.ui

import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

private val dateFormat = DateTimeFormatter.ofPattern("EEE, MMM d, yyyy")
private val timeFormat = DateTimeFormatter.ofPattern("h:mm a")

// "2027-06-01" -> "Tue, Jun 1, 2027"
fun formatDate(isoDate: String): String = LocalDate.parse(isoDate).format(dateFormat)

// "15:00" -> "3:00 PM"
fun formatTime(time: String): String = LocalTime.parse(time).format(timeFormat)

fun travelersLabel(count: Int): String = if (count == 1) "1 traveler" else "$count travelers"

// The date picker works in milliseconds (UTC); the app stores "yyyy-MM-dd".
fun millisToIsoDate(millis: Long): String =
    Instant.ofEpochMilli(millis).atZone(ZoneOffset.UTC).toLocalDate().toString()

fun isoDateToMillis(isoDate: String): Long =
    LocalDate.parse(isoDate).atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()
