package edu.matiasborra.physiocare.data.models.record

import com.google.gson.annotations.SerializedName

data class CountResponse(
    @SerializedName("ok")
    val ok: Boolean,

    @SerializedName("result")
    val result: Int? = null,

    @SerializedName("error")
    val error: String? = null
)