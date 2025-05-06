package edu.matiasborra.physiocare.data.model.patient

import com.google.gson.annotations.SerializedName

data class PatientResponse(
    @SerializedName("ok")
    val ok: Boolean,

    @SerializedName("result")
    val result: Patient? = null,

    @SerializedName("error")
    val error: String? = null,

    @SerializedName("message")
    val message: String? = null
)