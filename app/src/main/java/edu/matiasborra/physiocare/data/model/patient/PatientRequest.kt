package edu.matiasborra.physiocare.data.model.patient

import com.google.gson.annotations.SerializedName

data class PatientRequest(
    @SerializedName("name")
    val name: String,

    @SerializedName("surname")
    val surname: String,

    @SerializedName("birthDate")
    val birthDate: String,

    @SerializedName("address")
    val address: String,

    @SerializedName("insuranceNumber")
    val insuranceNumber: String
)