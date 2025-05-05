package edu.matiasborra.physiocare.data.models.record

import com.google.gson.annotations.SerializedName

data class RecordsResponse(
    @SerializedName("ok")
    val ok: Boolean,

    @SerializedName("result")
    val result: List<Record>? = null,

    @SerializedName("error")
    val error: String? = null,

    @SerializedName("message")
    val message: String? = null
)