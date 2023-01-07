package com.leandro1995.retoandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        observer()
    }

    private fun observer() {

        homeBinding.apply {

            navView.setupWithNavController(findNavController(R.id.homeNavHost))
        }
    }
}