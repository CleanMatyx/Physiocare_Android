package edu.matiasborra.physiocare.data.model.record

import com.google.gson.annotations.SerializedName

data class AppointmentRequest(
    @SerializedName("date")
    val date: String,

    @SerializedName("physio")
    val physio: String,

    @SerializedName("diagnosis")
    val diagnosis: String,

    @SerializedName("treatment")
    val treatment: String,

    @SerializedName("observations")
    val observations: String
)