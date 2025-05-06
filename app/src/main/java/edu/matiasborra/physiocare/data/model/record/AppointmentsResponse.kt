package edu.matiasborra.physiocare.data.model.record

import com.google.gson.annotations.SerializedName

data class AppointmentsResponse(
    @SerializedName("ok")
    val ok: Boolean,

    @SerializedName("result")
    val result: List<Appointment>? = null,

    @SerializedName("error")
    val error: String? = null
)