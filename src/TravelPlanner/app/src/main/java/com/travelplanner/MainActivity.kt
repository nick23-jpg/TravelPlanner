package com.travelplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.travelplanner.ui.TripViewModel
import com.travelplanner.ui.screens.ActivityFormScreen
import com.travelplanner.ui.screens.TripDetailScreen
import com.travelplanner.ui.screens.TripFormScreen
import com.travelplanner.ui.screens.TripListScreen
import com.travelplanner.ui.theme.TravelPlannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelPlannerTheme {
                TravelPlannerApp()
            }
        }
    }
}

// The screens and the routes between them. One TripViewModel is shared by every screen.
@Composable
fun TravelPlannerApp() {
    val viewModel: TripViewModel = viewModel()
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "trips") {

        composable("trips") {
            TripListScreen(
                viewModel = viewModel,
                onAddTrip = { navController.navigate("tripForm") },
                onOpenTrip = { tripId -> navController.navigate("trip/$tripId") }
            )
        }

        composable(
            route = "tripForm?tripId={tripId}",
            arguments = listOf(navArgument("tripId") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            })
        ) { entry ->
            TripFormScreen(
                viewModel = viewModel,
                tripId = entry.arguments?.getString("tripId"),
                onDone = { navController.popBackStack() }
            )
        }

        composable("trip/{tripId}") { entry ->
            val tripId = entry.arguments?.getString("tripId") ?: return@composable
            TripDetailScreen(
                viewModel = viewModel,
                tripId = tripId,
                onBack = { navController.popBackStack() },
                onEditTrip = { navController.navigate("tripForm?tripId=$tripId") },
                onAddActivity = { navController.navigate("activityForm/$tripId") },
                onEditActivity = { activityId ->
                    navController.navigate("activityForm/$tripId?activityId=$activityId")
                }
            )
        }

        composable(
            route = "activityForm/{tripId}?activityId={activityId}",
            arguments = listOf(
                navArgument("tripId") { type = NavType.StringType },
                navArgument("activityId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { entry ->
            val tripId = entry.arguments?.getString("tripId") ?: return@composable
            ActivityFormScreen(
                viewModel = viewModel,
                tripId = tripId,
                activityId = entry.arguments?.getString("activityId"),
                onDone = { navController.popBackStack() }
            )
        }
    }
}
