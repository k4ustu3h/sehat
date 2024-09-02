package k4ustu3h.sehat.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import k4ustu3h.sehat.feature.addmedication.navigation.addMedicationGraph
import k4ustu3h.sehat.feature.calendar.navigation.calendarGraph
import k4ustu3h.sehat.feature.history.historyGraph
import k4ustu3h.sehat.feature.home.navigation.HomeDestination
import k4ustu3h.sehat.feature.home.navigation.homeGraph
import k4ustu3h.sehat.feature.medicationconfirm.navigation.MEDICATION
import k4ustu3h.sehat.feature.medicationconfirm.navigation.MedicationConfirmDestination
import k4ustu3h.sehat.feature.medicationconfirm.navigation.medicationConfirmGraph
import k4ustu3h.sehat.feature.medicationdetail.MedicationDetailDestination
import k4ustu3h.sehat.feature.medicationdetail.medicationDetailGraph
import k4ustu3h.sehat.util.navigateSingleTop

@Composable
fun SehatNavHost(
    bottomBarVisibility: MutableState<Boolean>,
    fabVisibility: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HomeDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            navigateToMedicationDetail = {
                val bundle = Bundle()
                bundle.putParcelable(MEDICATION, it)
                navController.currentBackStackEntry?.savedStateHandle.apply {
                    this?.set(MEDICATION, bundle)
                }
                navController.navigate(MedicationDetailDestination.route)
            }
        )
        historyGraph(
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            navigateToMedicationDetail = {
                val bundle = Bundle()
                bundle.putParcelable(MEDICATION, it)
                navController.currentBackStackEntry?.savedStateHandle.apply {
                    this?.set(MEDICATION, bundle)
                }
                navController.navigate(MedicationDetailDestination.route)
            }
        )
        medicationDetailGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            onBackClicked = { navController.navigateUp() }
        )
        calendarGraph(bottomBarVisibility, fabVisibility)
        addMedicationGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            onBackClicked = { navController.navigateUp() },
            navigateToMedicationConfirm = {
                // TODO: Replace with medication id
                val bundle = Bundle()
                bundle.putParcelableArrayList(MEDICATION, ArrayList(it))
                navController.currentBackStackEntry?.savedStateHandle.apply {
                    this?.set(MEDICATION, bundle)
                }
                navController.navigate(MedicationConfirmDestination.route)
            }
        )
        medicationConfirmGraph(
            navController = navController,
            bottomBarVisibility = bottomBarVisibility,
            fabVisibility = fabVisibility,
            onBackClicked = { navController.navigateUp() },
            navigateToHome = {
                navController.navigateSingleTop(HomeDestination.route)
            }
        )
    }
}
