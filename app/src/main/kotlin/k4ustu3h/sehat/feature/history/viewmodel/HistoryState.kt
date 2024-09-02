package k4ustu3h.sehat.feature.history.viewmodel

import k4ustu3h.sehat.domain.model.Medication

data class HistoryState(
    val medications: List<Medication> = emptyList()
)
