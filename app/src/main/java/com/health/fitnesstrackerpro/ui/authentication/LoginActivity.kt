package com.health.fitnesstrackerpro.ui.authentication


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.health.fitnesstrackerpro.base.BaseActivity
import com.health.fitnesstrackerpro.databinding.ActivityRegistrationBinding
import com.health.fitnesstrackerpro.ui.home.HomeActivity


class LoginActivity : BaseActivity<ActivityRegistrationBinding>() {

    override fun getViewBinding() = ActivityRegistrationBinding.inflate(layoutInflater)

    private var mAuth: FirebaseAuth? = null
    private var registrationViewModel: RegistrationViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()

        // Initialize ViewModel
        registrationViewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)

        // Now you can access views using `binding` instance
        val email = binding.editTextEmail.text.toString()
        val password = binding.editTextPassword.text.toString()

        binding.buttonLogin.setOnClickListener {

            loginUser()

        }

        registrationViewModel!!.loginSuccessLiveData.observe(this){ success ->

            if (success){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()

            }

        }
    }

    private fun loginUser() {
        val email: String = binding.editTextEmail.text.toString().trim()
        val password: String = binding.editTextPassword.text.toString().trim()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
        } else {
            // Assuming you have a login method in your ViewModel
            registrationViewModel?.loginUser(email, password)
        }
    }
}