package k4ustu3h.sehat.feature.home.viewmodel

import k4ustu3h.sehat.domain.model.Medication

data class HomeState(
    val greeting: String = "",
    val userName: String = "",
    val lastSelectedDate: String,
    val medications: List<Medication> = emptyList()
)
