package edu.matiasborra.physiocare.data.models.patient

import com.google.gson.annotations.SerializedName
import edu.matiasborra.physiocare.model.patient.Patient

/**
 * DTO para la respuesta del endpoint GET /patients,
 * cubre tanto éxito como dos tipos de error ("error" y "message").
 */
data class PatientsResponse(
    @SerializedName("ok")
    val ok: Boolean,

    @SerializedName("result")
    val result: List<Patient>? = null,

    @SerializedName("error")
    val error: String? = null,

    @SerializedName("message")
    val message: String? = null
)
