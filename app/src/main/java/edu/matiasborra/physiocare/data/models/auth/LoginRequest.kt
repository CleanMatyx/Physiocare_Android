package edu.matiasborra.physiocare.data.models.auth

import com.google.gson.annotations.SerializedName

/**
 * Solicitud de inicio de sesión.
 * @property login Nombre de usuario.
 * @property password Contraseña del usuario.
 * @constructor Crea una instancia de LoginRequest.
 * @author Matias Borra
 */
data class LoginRequest(
    @SerializedName("login")
    val login: String,
    @SerializedName("password")
    val password: String
)