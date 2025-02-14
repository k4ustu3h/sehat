package k4ustu3h.sehat.domain.repository

import k4ustu3h.sehat.domain.model.Medication
import kotlinx.coroutines.flow.Flow

interface MedicationRepository {

    suspend fun insertMedications(medications: List<Medication>): Flow<List<Medication>>

    suspend fun deleteMedication(medication: Medication)

    suspend fun updateMedication(medication: Medication)

    fun getAllMedications(): Flow<List<Medication>>

    fun getMedicationsForDate(date: String): Flow<List<Medication>>

    suspend fun getMedicationById(id: Long): Medication?
}
