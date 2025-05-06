package edu.matiasborra.physiocare.data.model.record

import com.google.gson.annotations.SerializedName
import edu.matiasborra.physiocare.data.model.physio.Physio

data class Appointment(
    @SerializedName("_id")
    val id: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("physio")
    val physio: Physio,

    @SerializedName("diagnosis")
    val diagnosis: String,

    @SerializedName("treatment")
    val treatment: String,

    @SerializedName("observations")
    val observations: String
)