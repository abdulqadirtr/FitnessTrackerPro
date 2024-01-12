package com.health.fitnesstrackerpro.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.health.fitnesstrackerpro.R
import com.health.fitnesstrackerpro.ui.home.HomeActivity
import com.health.fitnesstrackerpro.ui.signup.SignUpActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null) {
            // User is already authenticated, navigate to HomeActivity
            startActivity(Intent(this, HomeActivity::class.java))
            finish() // Optional: Close the MainActivity if needed
        } else {
            // User is not authenticated, decide whether to show RegistrationActivity or LoginActivity
            decideAuthenticationFlow()
        }
    }

    private fun decideAuthenticationFlow() {
        // You might have your own logic here to decide whether to show RegistrationActivity or LoginActivity
        // For simplicity, let's show the RegistrationActivity by default
        startActivity(Intent(this, SignUpActivity::class.java))
        finish() // Optional: Close the MainActivity if needed
    }
}