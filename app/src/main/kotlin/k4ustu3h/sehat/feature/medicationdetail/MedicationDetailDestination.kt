package k4ustu3h.sehat.feature.medicationdetail

import android.os.Bundle
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import k4ustu3h.sehat.core.navigation.SehatNavigationDestination
import k4ustu3h.sehat.domain.model.Medication
import k4ustu3h.sehat.feature.medicationconfirm.navigation.MEDICATION

object MedicationDetailDestination : SehatNavigationDestination {
    override val route = "medication_detail_route"
    override val destination = "medication_detail_destination"
}

fun NavGraphBuilder.medicationDetailGraph(navController: NavController, bottomBarVisibility: MutableState<Boolean>, fabVisibility: MutableState<Boolean>, onBackClicked: () -> Unit) {

    composable(
        route = MedicationDetailDestination.route,
    ) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = false
            fabVisibility.value = false
        }
        val medicationBundle = navController.previousBackStackEntry?.savedStateHandle?.get<Bundle>(
            MEDICATION
        )
        val medication = medicationBundle?.getParcelable<Medication>(MEDICATION)
        MedicationDetailRoute(medication, onBackClicked)
    }
}
