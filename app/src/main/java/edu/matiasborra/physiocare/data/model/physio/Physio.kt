package edu.matiasborra.physiocare.data.model.physio

import com.google.gson.annotations.SerializedName

data class Physio(
    @SerializedName("_id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("surname")
    val surname: String,

    @SerializedName("specialty")
    val specialty: String,

    @SerializedName("licenseNumber")
    val licenseNumber: String,

    @SerializedName("__v")
    val version: Int
)