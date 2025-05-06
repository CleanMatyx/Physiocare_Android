package edu.matiasborra.physiocare.data.remote

import edu.matiasborra.physiocare.data.model.auth.LoginRequest
import edu.matiasborra.physiocare.data.model.auth.LoginResponse
import edu.matiasborra.physiocare.data.model.generic.GenericResponse
import edu.matiasborra.physiocare.data.model.patient.PatientRequest
import edu.matiasborra.physiocare.data.model.patient.PatientResponse
import edu.matiasborra.physiocare.data.model.patient.PatientsResponse
import edu.matiasborra.physiocare.data.model.physio.PhysioRequest
import edu.matiasborra.physiocare.data.model.physio.PhysioResponse
import edu.matiasborra.physiocare.data.model.physio.PhysiosResponse
import edu.matiasborra.physiocare.data.model.record.AppointmentRequest
import edu.matiasborra.physiocare.data.model.record.AppointmentResponse
import edu.matiasborra.physiocare.data.model.record.AppointmentsResponse
import edu.matiasborra.physiocare.data.model.record.CountResponse
import edu.matiasborra.physiocare.data.model.record.RecordRequest
import edu.matiasborra.physiocare.data.model.record.RecordResponse
import edu.matiasborra.physiocare.data.model.record.RecordsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Clase que proporciona la configuración de Retrofit para acceder a la API de PhysioCare.
 * @author Matias Borra
 */
class PhysioCareApi {
    companion object {
        const val BASE_URL = "https://matiasborra.es/api/physio/"

        /**
         * Obtiene una instancia de PhysioCareAPIInterface configurada con Retrofit.
         * @return PhysioCareAPIInterface Instancia de la interfaz de la API.
         * @author Matias Borra
         */
        fun getRetrofit2Api(): PhysioCareAPIInterface {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
                .create(PhysioCareAPIInterface::class.java)
        }
    }
}

interface PhysioCareAPIInterface {

    // Autenticación
    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    // Pacientes
    @GET("patients")
    suspend fun getPatients(
        @Header("Authorization") token: String
    ): PatientsResponse

    @GET("patients/{id}")
    suspend fun getPatientById(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): PatientResponse

    @POST("patients")
    suspend fun createPatient(
        @Header("Authorization") token: String,
        @Body request: PatientRequest
    ): PatientResponse

    @GET("patients/find")
    suspend fun findPatientsBySurname(
        @Header("Authorization") token: String,
        @Query("surname") surname: String
    ): PatientsResponse

    @PUT("patients/{id}")
    suspend fun updatePatient(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Body request: PatientRequest
    ): PatientResponse

    @DELETE("patients/{id}")
    suspend fun deletePatient(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): GenericResponse

    // Fisioterapeutas
    @GET("physios")
    suspend fun getPhysios(
        @Header("Authorization") token: String
    ): PhysiosResponse

    @GET("physios/{id}")
    suspend fun getPhysioById(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): PhysioResponse

    @POST("physios")
    suspend fun createPhysio(
        @Header("Authorization") token: String,
        @Body request: PhysioRequest
    ): PhysioResponse

    @PUT("physios/{id}")
    suspend fun updatePhysio(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Body request: PhysioRequest
    ): PhysioResponse

    @DELETE("physios/{id}")
    suspend fun deletePhysio(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): GenericResponse

    // Expedientes y citas
    @GET("records")
    suspend fun getRecords(
        @Header("Authorization") token: String
    ): RecordsResponse

    @GET("records/find")
    suspend fun findRecordsBySurname(
        @Header("Authorization") token: String,
        @Query("surname") surname: String
    ): RecordsResponse

    @GET("records/{id}")
    suspend fun getRecordById(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): RecordResponse

    @POST("records")
    suspend fun createRecord(
        @Header("Authorization") token: String,
        @Body request: RecordRequest
    ): RecordResponse

    @DELETE("records/{id}")
    suspend fun deleteRecord(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): GenericResponse

    @GET("records/{id}/appointments")
    suspend fun getRecordAppointments(
        @Header("Authorization") token: String,
        @Path("id") recordId: String
    ): AppointmentsResponse

    @POST("records/{id}/appointments")
    suspend fun addAppointment(
        @Header("Authorization") token: String,
        @Path("id") recordId: String,
        @Body request: AppointmentRequest
    ): AppointmentResponse

    @GET("records/patient/{patientId}/appointments/count")
    suspend fun getPatientAppointmentsCount(
        @Header("Authorization") token: String,
        @Path("patientId") patientId: String
    ): CountResponse

    @GET("records/appointments/count")
    suspend fun getAppointmentsCount(
        @Header("Authorization") token: String
    ): CountResponse
}