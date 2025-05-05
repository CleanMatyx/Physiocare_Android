package edu.matiasborra.physiocare.data.models.physio

import com.google.gson.annotations.SerializedName

data class PhysioResponse(
    @SerializedName("ok")
    val ok: Boolean,

    @SerializedName("result")
    val result: Physio? = null,

    @SerializedName("error")
    val error: String? = null
)