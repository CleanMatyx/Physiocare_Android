package edu.matiasborra.physiocare.data.model.record

import com.google.gson.annotations.SerializedName

data class RecordRequest(
    @SerializedName("patient")
    val patient: String,

    @SerializedName("medicalRecord")
    val medicalRecord: String,

    @SerializedName("appointments")
    val appointments: List<AppointmentRequest>
)