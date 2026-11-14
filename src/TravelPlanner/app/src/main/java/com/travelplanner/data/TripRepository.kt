package com.travelplanner.data

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

// Saves and loads all trips as one JSON file in the app's private storage (offline, no server).
class TripRepository(context: Context) {

    private val file = File(context.filesDir, "trips.json")
    private val json = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    fun loadTrips(): List<Trip> {
        if (!file.exists()) return emptyList()
        return try {
            json.decodeFromString<List<Trip>>(file.readText())
        } catch (e: Exception) {
            emptyList()
        }
    }

    fun saveTrips(trips: List<Trip>) {
        file.writeText(json.encodeToString(trips))
    }
}
