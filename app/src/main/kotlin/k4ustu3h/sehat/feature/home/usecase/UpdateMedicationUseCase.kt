package k4ustu3h.sehat.feature.home.usecase

import k4ustu3h.sehat.domain.model.Medication
import k4ustu3h.sehat.domain.repository.MedicationRepository
import javax.inject.Inject

class UpdateMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {

    suspend fun updateMedication(medication: Medication) {
        return repository.updateMedication(medication)
    }
}
