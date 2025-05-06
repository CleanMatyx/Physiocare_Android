package edu.matiasborra.physiocare.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import edu.matiasborra.physiocare.data.repository.Repository
import edu.matiasborra.physiocare.domain.model.Patient

/**
 * Caso de uso para obtener el listado de pacientes.
 * - Recibe el token (ya en sesión), llama al repositorio y mapea DTO → dominio.
 */
class GetPatientsUseCase(
    private val repository: Repository
) {
    /**
     * Devuelve un flujo con la lista de pacientes de dominio.
     * @param token Token JWT con "Bearer " prefijado.
     * @return Flow<List<Patient>>
     */
//    operator fun invoke(token: String): Flow<List<Patient>> =
//        repository.fetchPatients(token).map { resp ->
//            if (!resp.ok) {
//                throw Exception(resp.error ?: resp.message ?: "No se pudieron cargar pacientes")
//            }
//            // Mapea cada DTO Patient a dominio
//            resp.result!!.map { dto ->
//                Patient(
//                    id              = dto.id,
//                    name            = dto.name,
//                    surname         = dto.surname,
//                    birthDate       = dto.birthDate,         // Podrías parsear a LocalDate
//                    address         = dto.address,
//                    insuranceNumber = dto.insuranceNumber,
//                    email           = dto.email
//                )
//            }
//        }
}
