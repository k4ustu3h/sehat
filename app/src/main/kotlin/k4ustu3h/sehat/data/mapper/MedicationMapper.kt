package k4ustu3h.sehat.data.mapper

import k4ustu3h.sehat.data.entity.MedicationEntity
import k4ustu3h.sehat.domain.model.Medication
import k4ustu3h.sehat.util.MedicationType
import java.util.Date

fun MedicationEntity.toMedication(): Medication {
    return Medication(
        id = id,
        name = name,
        dosage = dosage,
        frequency = recurrence,
        startDate = startDate ?: Date(),
        endDate = endDate,
        medicationTime = medicationTime,
        medicationTaken = medicationTaken,
        type = MedicationType.valueOf(type)
    )
}

fun Medication.toMedicationEntity(): MedicationEntity {
    return MedicationEntity(
        id = id,
        name = name,
        dosage = dosage,
        recurrence = frequency,
        startDate = startDate,
        endDate = endDate,
        medicationTime = medicationTime,
        medicationTaken = medicationTaken,
        type = type.name
    )
}