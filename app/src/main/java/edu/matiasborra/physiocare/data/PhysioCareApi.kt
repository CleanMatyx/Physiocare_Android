package edu.matiasborra.physiocare.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
    // Aquí puedes definir los métodos de la API que necesites
    // Por ejemplo:
    // @GET("endpoint")
    // suspend fun getSomething(@Header("Authorization") token: String): ResponseType
}