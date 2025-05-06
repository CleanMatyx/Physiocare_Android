package edu.matiasborra.physiocare.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import edu.matiasborra.physiocare.PhysioCareApp
import edu.matiasborra.physiocare.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel by viewModels<AuthViewModel> {
        AuthViewModelFactory(PhysioCareApp.loginUseCase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val user = binding.etLogin.text.toString()
            val pass = binding.etPassword.text.toString()
            viewModel.login(user, pass)
        }

        // Observa los estados de login
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                binding.progressBar.isVisible = state is LoginState.Loading
                when (state) {
                    is LoginState.Success -> {
                        // Navegar según rol
                        val role = state.response.role  // asume que User trae el role
                        startActivity(Intent(
                            this@LoginActivity,
                            if (role == "physio") PhysioActivity::class.java else PatientActivity::class.java))
                        finish()
                    }
                    is LoginState.Error -> binding.tvError.text = state.message
                    else -> Unit
                }
            }
        }
    }
}
