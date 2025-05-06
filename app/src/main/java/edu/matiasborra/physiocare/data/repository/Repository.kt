package edu.matiasborra.physiocare.data.repository

import edu.matiasborra.physiocare.data.model.auth.LoginRequest
import edu.matiasborra.physiocare.data.model.auth.LoginResponse
import edu.matiasborra.physiocare.utils.SessionManager
import edu.matiasborra.physiocare.data.model.patient.PatientRequest
import edu.matiasborra.physiocare.data.model.patient.PatientResponse
import edu.matiasborra.physiocare.data.model.patient.PatientsResponse
import edu.matiasborra.physiocare.data.model.physio.PhysioRequest
import edu.matiasborra.physiocare.data.model.physio.PhysioResponse
import edu.matiasborra.physiocare.data.model.physio.PhysiosResponse
import edu.matiasborra.physiocare.data.model.record.*
import edu.matiasborra.physiocare.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class Repository(
    private val sessionManager: SessionManager,
    private val ds: RemoteDataSource
) {

    /** Login y gestión de token en sesión */
    suspend fun login(request: LoginRequest): LoginResponse {
        val response = ds.login(request)
        response.token?.let { sessionManager.saveSession(it, request.login) }
        return response
    }

    /** Elimina el token de la sesión */
    suspend fun logout() {
        sessionManager.clearSession()
    }

    /** Flujo con el par (token, username) */
    fun getSessionFlow(): Flow<Pair<String?, String?>> =
        sessionManager.sessionFlow

    //–– PACIENTES ––//

//    /** Lista todos los pacientes */
//    fun fetchPatients(token: String): Flow<PatientsResponse> =
//        ds.getPatients(token)
//
//    /** Detalle de un paciente */
//    fun fetchPatientById(token: String, id: String): Flow<PatientResponse> =
//        ds.getPatientById(token, id)
//
//    /** Crea un paciente */
//    suspend fun createPatient(token: String, request: PatientRequest): PatientResponse =
//        ds.createPatient(token, request)
//
//    /** Actualiza un paciente */
//    suspend fun updatePatient(token: String, id: String, request: PatientRequest): PatientResponse =
//        ds.updatePatient(token, id, request)
//
//    /** Elimina un paciente */
//    suspend fun deletePatient(token: String, id: String) =
//        ds.deletePatient(token, id)
//
//    /** Busca pacientes por apellido */
//    fun findPatientsBySurname(token: String, surname: String): Flow<PatientsResponse> =
//        ds.findPatientsBySurname(token, surname)
//
//    //–– FISIOTERAPEUTAS ––//
//
//    fun fetchPhysios(token: String): Flow<PhysiosResponse> =
//        ds.getPhysios(token)
//
//    fun fetchPhysioById(token: String, id: String): Flow<PhysioResponse> =
//        ds.getPhysioById(token, id)
//
//    suspend fun createPhysio(token: String, request: PhysioRequest): PhysioResponse =
//        ds.createPhysio(token, request)
//
//    suspend fun updatePhysio(token: String, id: String, request: PhysioRequest): PhysioResponse =
//        ds.updatePhysio(token, id, request)
//
//    suspend fun deletePhysio(token: String, id: String) =
//        ds.deletePhysio(token, id)
//
//    //–– EXPEDIENTES & CITAS ––//
//
//    fun fetchRecords(token: String): Flow<RecordsResponse> =
//        ds.getRecords(token)
//
//    fun fetchRecordById(token: String, id: String): Flow<RecordResponse> =
//        ds.getRecordById(token, id)
//
//    suspend fun createRecord(token: String, request: RecordRequest): RecordResponse =
//        ds.createRecord(token, request)
//
//    suspend fun deleteRecord(token: String, id: String) =
//        ds.deleteRecord(token, id)
//
//    fun findRecordsBySurname(token: String, surname: String): Flow<RecordsResponse> =
//        ds.findRecordsBySurname(token, surname)
//
//    fun fetchRecordAppointments(token: String, recordId: String): Flow<AppointmentsResponse> =
//        ds.getRecordAppointments(token, recordId)
//
//    suspend fun addAppointment(token: String, recordId: String, request: AppointmentRequest
//    ): AppointmentResponse =
//        ds.addAppointment(token, recordId, request)
//
//    fun fetchPatientAppointmentsCount(token: String, patientId: String): Flow<CountResponse> =
//        ds.getPatientAppointmentsCount(token, patientId)
//
//    fun fetchAllAppointmentsCount(token: String): Flow<CountResponse> =
//        ds.getAppointmentsCount(token)
}
