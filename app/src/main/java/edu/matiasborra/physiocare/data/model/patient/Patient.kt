package edu.matiasborra.physiocare.data.model.patient

import com.google.gson.annotations.SerializedName

data class Patient(
    @SerializedName("_id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("surname")
    val surname: String,

    @SerializedName("birthDate")
    val birthDate: String,

    @SerializedName("address")
    val address: String,

    @SerializedName("insuranceNumber")
    val insuranceNumber: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("__v")
    val version: Int
)