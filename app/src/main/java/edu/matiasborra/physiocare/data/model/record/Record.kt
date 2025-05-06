package edu.matiasborra.physiocare.data.model.record

import com.google.gson.annotations.SerializedName
import edu.matiasborra.physiocare.data.model.patient.Patient

data class Record(
    @SerializedName("_id")
    val id: String,

    @SerializedName("patient")
    val patient: Patient?,

    @SerializedName("medicalRecord")
    val medicalRecord: String,

    @SerializedName("appointments")
    val appointments: List<Appointment>
)