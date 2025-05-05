package edu.matiasborra.physiocare.ui.auth

import edu.matiasborra.physiocare.data.models.auth.LoginResponse

/**
 * Estado de la autenticación del usuario.
 * @author Matias Borra
 */
sealed class LoginState {
    /**
     * Estado inactivo de la autenticación.
     * @author Matias Borra
     */
    object Idle: LoginState()

    /**
     * Estado de carga de la autenticación.
     * @author Matias Borra
     */
    object Loading: LoginState()

    /**
     * Estado de éxito de la autenticación.
     * @property response Respuesta de la autenticación.
     * @author Matias Borra
     */
    data class Success(val response: LoginResponse): LoginState()

    /**
     * Estado de error de la autenticación.
     * @property message Mensaje de error.
     * @author Matias Borra
     */
    data class Error(val message: String): LoginState()
}