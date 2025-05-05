package edu.matiasborra.physiocare.data.models.auth

import com.google.gson.annotations.SerializedName

/**
 * Respuesta de inicio de sesión.
 * @property ok Indica si la autenticación fue exitosa.
 * @property token Token de autenticación.
 * @property error Mensaje de la respuesta.
 * @constructor Crea una instancia de LoginResponse.
 * @author Matias Borra
 */
data class LoginResponse(
    @SerializedName("ok")
    val ok: Boolean,
    @SerializedName("token")
    val token: String?,
    @SerializedName("error")
    val error: String?
)
