package k4ustu3h.sehat.feature.medicationdetail.usecase

import k4ustu3h.sehat.domain.model.Medication
import k4ustu3h.sehat.domain.repository.MedicationRepository
import javax.inject.Inject

class GetMedicationUseCase @Inject constructor(
    private val repository: MedicationRepository
) {
    suspend operator fun invoke(id: Long): Medication? = repository.getMedicationById(id)
}
