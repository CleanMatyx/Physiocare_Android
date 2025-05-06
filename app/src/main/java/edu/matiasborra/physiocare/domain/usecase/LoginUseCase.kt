package edu.matiasborra.physiocare.domain.usecase

import edu.matiasborra.physiocare.data.model.auth.LoginRequest
import edu.matiasborra.physiocare.data.repository.Repository
import edu.matiasborra.physiocare.domain.model.User

/**
 * Caso de uso para iniciar sesión.
 * - Llama al repositorio, guarda el token en sesión y devuelve un modelo de dominio User.
 */
class LoginUseCase(
    private val repository: Repository
) {
    /**
     * Ejecuta el login con usuario y contraseña.
     * @param login Nombre de usuario.
     * @param password Contraseña.
     * @return Usuario de dominio con token.
     * @throws Exception si ok == false o error de red.
     */
    suspend operator fun invoke(login: String, password: String): User {
        // Llamada al repositorio
        val response = repository.login(LoginRequest(login, password))
        // Control de errores de API
        if (!response.ok) {
            throw Exception(response.error ?: "Error en el login")
        }
        // Map a modelo de dominio
        return User(
            username = login,
            token    = response.token!!
        )
    }
}
