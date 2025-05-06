package edu.matiasborra.physiocare.data.remote

import edu.matiasborra.physiocare.data.model.auth.LoginRequest
import edu.matiasborra.physiocare.data.model.auth.LoginResponse
import edu.matiasborra.physiocare.data.model.generic.GenericResponse
import edu.matiasborra.physiocare.data.model.patient.*
import edu.matiasborra.physiocare.data.model.physio.*
import edu.matiasborra.physiocare.data.model.record.*
import edu.matiasborra.physiocare.utils.SessionManager
import kotlinx.coroutines.flow.first

class RemoteDataSource(
    private val api: PhysioCareApi,
    private val session: SessionManager
) {

    private suspend fun authHeader(): String {
        val token = session.getToken().first()
            ?: throw IllegalStateException("No auth token found")
        return "Bearer $token"
    }

    // Auth
    suspend fun login(request: LoginRequest): LoginResponse =
        PhysioCareApi.getRetrofit2Api().login(request)

//    // Patients
//    suspend fun fetchAllPatients(): PatientsResponse =
//        api.getPatients(authHeader())
//
//    suspend fun fetchPatientById(id: String): PatientResponse =
//        api.getPatientById(authHeader(), id)
//
//    suspend fun createPatient(request: PatientRequest): PatientResponse =
//        api.createPatient(authHeader(), request)
//
//    suspend fun updatePatient(id: String, request: PatientRequest): PatientResponse =
//        api.updatePatient(authHeader(), id, request)
//
//    suspend fun deletePatient(id: String): GenericResponse =
//        api.deletePatient(authHeader(), id)
//
//    suspend fun findPatientsBySurname(surname: String): PatientsResponse =
//        api.findPatientsBySurname(authHeader(), surname)
//
//    // Physios
//    suspend fun fetchAllPhysios(): PhysiosResponse =
//        api.getPhysios(authHeader())
//
//    suspend fun fetchPhysioById(id: String): PhysioResponse =
//        api.getPhysioById(authHeader(), id)
//
//    suspend fun createPhysio(request: PhysioRequest): PhysioResponse =
//        api.createPhysio(authHeader(), request)
//
//    suspend fun updatePhysio(id: String, request: PhysioRequest): PhysioResponse =
//        api.updatePhysio(authHeader(), id, request)
//
//    suspend fun deletePhysio(id: String): GenericResponse =
//        api.deletePhysio(authHeader(), id)
//
//    // Records & Appointments
//    suspend fun fetchAllRecords(): RecordsResponse =
//        api.getRecords(authHeader())
//
//    suspend fun fetchRecordById(id: String): RecordResponse =
//        api.getRecordById(authHeader(), id)
//
//    suspend fun createRecord(request: RecordRequest): RecordResponse =
//        api.createRecord(authHeader(), request)
//
//    suspend fun deleteRecord(id: String): GenericResponse =
//        api.deleteRecord(authHeader(), id)
//
//    suspend fun findRecordsBySurname(surname: String): RecordsResponse =
//        api.findRecordsBySurname(authHeader(), surname)
//
//    suspend fun fetchRecordAppointments(recordId: String): AppointmentsResponse =
//        api.getRecordAppointments(authHeader(), recordId)
//
//    suspend fun addAppointment(recordId: String, request: AppointmentRequest): AppointmentResponse =
//        api.addAppointment(authHeader(), recordId, request)
//
//    suspend fun fetchPatientAppointmentsCount(patientId: String): CountResponse =
//        api.getPatientAppointmentsCount(authHeader(), patientId)
//
//    suspend fun fetchAllAppointmentsCount(): CountResponse =
//        api.getAppointmentsCount(authHeader())
}
