package edu.matiasborra.physiocare.data.models.record

import com.google.gson.annotations.SerializedName

data class AppointmentResponse(
    @SerializedName("ok")
    val ok: Boolean,

    @SerializedName("result")
    val result: Appointment? = null,

    @SerializedName("error")
    val error: String? = null
)