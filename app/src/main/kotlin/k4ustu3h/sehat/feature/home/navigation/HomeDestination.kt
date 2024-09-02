package k4ustu3h.sehat.feature.home.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import k4ustu3h.sehat.core.navigation.SehatNavigationDestination
import k4ustu3h.sehat.domain.model.Medication
import k4ustu3h.sehat.feature.home.HomeRoute

const val ASK_NOTIFICATION_PERMISSION = "notification_permission"
const val ASK_ALARM_PERMISSION = "alarm_permission"
object HomeDestination : SehatNavigationDestination {
    override val route = "home_route"
    override val destination = "home_destination"
}

fun NavGraphBuilder.homeGraph(navController: NavController, bottomBarVisibility: MutableState<Boolean>, fabVisibility: MutableState<Boolean>, navigateToMedicationDetail: (Medication) -> Unit) {
    composable(route = HomeDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
            fabVisibility.value = true
        }
        val askNotificationPermission = navController.currentBackStackEntry?.savedStateHandle?.get<Boolean>(
            ASK_NOTIFICATION_PERMISSION
        ) ?: false
        val askAlarmPermission = navController.currentBackStackEntry?.savedStateHandle?.get<Boolean>(
            ASK_ALARM_PERMISSION
        ) ?: false

        HomeRoute(navController, askNotificationPermission, askAlarmPermission, navigateToMedicationDetail)
    }
}
