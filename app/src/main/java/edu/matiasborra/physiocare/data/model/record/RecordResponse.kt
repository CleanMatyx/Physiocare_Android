package edu.matiasborra.physiocare.data.model.record

import com.google.gson.annotations.SerializedName

data class RecordResponse(
    @SerializedName("ok")
    val ok: Boolean,

    @SerializedName("result")
    val result: Record? = null,

    @SerializedName("error")
    val error: String? = null,

    @SerializedName("message")
    val message: String? = null
)