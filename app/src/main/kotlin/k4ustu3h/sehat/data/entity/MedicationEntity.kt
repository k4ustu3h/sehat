package k4ustu3h.sehat.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import k4ustu3h.sehat.util.MedicationType
import java.util.Date

@Entity
data class MedicationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val dosage: Int,
    val recurrence: String,
    val startDate: Date?,
    val endDate: Date,
    val medicationTaken: Boolean,
    val medicationTime: Date,
    @ColumnInfo(defaultValue = "TABLET")
    val type: String = MedicationType.getDefault().name
)
