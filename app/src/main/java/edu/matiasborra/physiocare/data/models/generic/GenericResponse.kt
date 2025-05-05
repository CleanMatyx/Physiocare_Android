package edu.matiasborra.physiocare.data.models.generic

import com.google.gson.annotations.SerializedName

data class GenericResponse(
    @SerializedName("ok")
    val ok: Boolean,

    @SerializedName("message")
    val message: String? = null,

    @SerializedName("error")
    val error: String? = null
)