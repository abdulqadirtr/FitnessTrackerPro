package com.health.fitnesstrackerpro.ui.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.health.fitnesstrackerpro.base.BaseActivity
import com.health.fitnesstrackerpro.databinding.ActivitySignupBinding
import com.health.fitnesstrackerpro.ui.authentication.LoginActivity
import com.health.fitnesstrackerpro.ui.authentication.RegistrationViewModel

class SignUpActivity: BaseActivity<ActivitySignupBinding>() {


    override fun getViewBinding() = ActivitySignupBinding.inflate(layoutInflater)

    private lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registrationViewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)

        binding.buttonSignup.setOnClickListener {
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                registrationViewModel.registerUser(email, password)
            } else {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textViewLoginLink.setOnClickListener {
            // Navigate to RegistrationActivity when the link is clicked
            startActivity(Intent(this, LoginActivity::class.java))
        }

        registrationViewModel.registrationSuccessLiveData.observe(this) { success ->
            if (success) {
                // Registration success, navigate to the LoginActivity
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish() // Optional: Close the signup activity if needed
            } else {
                // Registration failed, handle accordingly
                Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}