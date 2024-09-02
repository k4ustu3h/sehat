package k4ustu3h.sehat.feature.calendar.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import k4ustu3h.sehat.core.navigation.SehatNavigationDestination
import k4ustu3h.sehat.feature.calendar.CalendarRoute

object CalendarDestination : SehatNavigationDestination {
    override val route = "calendar_route"
    override val destination = "calendar_destination"
}

fun NavGraphBuilder.calendarGraph(bottomBarVisibility: MutableState<Boolean>, fabVisibility: MutableState<Boolean>) {
    composable(route = CalendarDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
            fabVisibility.value = false
        }
        CalendarRoute()
    }
}
