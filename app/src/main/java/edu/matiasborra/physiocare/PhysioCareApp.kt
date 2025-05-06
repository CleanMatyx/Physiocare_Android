package edu.matiasborra.physiocare

import android.app.Application
import edu.matiasborra.physiocare.utils.SessionManager
import edu.matiasborra.physiocare.data.remote.PhysioCareApi
import edu.matiasborra.physiocare.data.repository.Repository
import edu.matiasborra.physiocare.utils.dataStore
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhysioCareApp : Application() {

    companion object {
        lateinit var sessionManager: SessionManager
            private set

        lateinit var api: PhysioCareApi
            private set

        lateinit var repository: Repository
            private set
    }

    override fun onCreate() {
        super.onCreate()

        // Inicializa SessionManager usando el extension property dataStore
        sessionManager = SessionManager(dataStore)

        // Configura Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://matiasborra.es/physio/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(PhysioCareApi::class.java)

        // Inicializa el repositorio
        repository = Repository(api, sessionManager)
    }
}
