package k4ustu3h.sehat.feature.medicationconfirm.usecase

import k4ustu3h.sehat.domain.model.Medication
import k4ustu3h.sehat.domain.repository.MedicationRepository
import javax.inject.Inject

class AddMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {
    suspend fun addMedication(medications: List<Medication>) {
        repository.insertMedications(medications)
    }
}
