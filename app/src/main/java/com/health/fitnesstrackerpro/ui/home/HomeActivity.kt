package com.health.fitnesstrackerpro.ui.home

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.health.fitnesstrackerpro.base.BaseActivity
import com.health.fitnesstrackerpro.databinding.ActivityHomeBinding
import com.health.fitnesstrackerpro.databinding.ActivityRegistrationBinding

class HomeActivity() : BaseActivity<ActivityHomeBinding>() {

    override fun getViewBinding() = ActivityHomeBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)
    }

}