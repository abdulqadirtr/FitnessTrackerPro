package com.health.fitnesstrackerpro.ui.authentication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class RegistrationViewModel(): ViewModel() {
    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val registrationSuccessLiveData = MutableLiveData<Boolean>()

    val loginSuccessLiveData = MutableLiveData<Boolean>()

    fun registerUser(email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Registration success
                    // You can handle success or navigate to the next screen here
                    registrationSuccessLiveData.postValue(true)
                    println(task.isSuccessful)
                } else {
                    // Registration failed
                    // You can handle the failure, display a message, etc.
                    println(task.exception)
                    registrationSuccessLiveData.postValue(false)
                }
            }
    }

    fun loginUser(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                loginSuccessLiveData.value = task.isSuccessful
            }
    }
}