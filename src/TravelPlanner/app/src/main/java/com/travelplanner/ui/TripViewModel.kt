package com.travelplanner.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.travelplanner.data.Activity
import com.travelplanner.data.Trip
import com.travelplanner.data.TripRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// Holds the trips for every screen and saves each change to trips.json.
class TripViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = TripRepository(application)

    private val _trips = MutableStateFlow(repository.loadTrips())
    val trips: StateFlow<List<Trip>> = _trips.asStateFlow()

    fun getTrip(id: String): Trip? = _trips.value.find { it.id == id }

    // Adds a new trip, or replaces the trip with the same id.
    fun saveTrip(trip: Trip) {
        val list = _trips.value.toMutableList()
        val index = list.indexOfFirst { it.id == trip.id }
        if (index >= 0) list[index] = trip else list.add(trip)
        update(list)
    }

    fun deleteTrip(id: String) {
        update(_trips.value.filter { it.id != id })
    }

    // Adds a new activity, or replaces the activity with the same id.
    fun saveActivity(tripId: String, activity: Activity) {
        val trip = getTrip(tripId) ?: return
        val activities = trip.activities.filter { it.id != activity.id } + activity
        saveTrip(trip.copy(activities = activities))
    }

    fun deleteActivity(tripId: String, activityId: String) {
        val trip = getTrip(tripId) ?: return
        saveTrip(trip.copy(activities = trip.activities.filter { it.id != activityId }))
    }

    private fun update(list: List<Trip>) {
        _trips.value = list
        repository.saveTrips(list)
    }
}
