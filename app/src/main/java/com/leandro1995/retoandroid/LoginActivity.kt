package com.leandro1995.retoandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.leandro1995.retoandroid.config.callback.intent.LoginIntentCallBack
import com.leandro1995.retoandroid.databinding.ActivityLoginBinding
import com.leandro1995.retoandroid.extension.lifecycleScopeCreate
import com.leandro1995.retoandroid.util.MessageUtil
import com.leandro1995.retoandroid.viewmodel.LoginViewModel
import com.leandro1995.retoandroid.viewmodel.config.LoginConfig
import kotlinx.coroutines.flow.collect

class LoginActivity : AppCompatActivity(), LoginIntentCallBack {

    private lateinit var loginBinding: ActivityLoginBinding

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LoginConfig.instance(loginIntentCallBack = this)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginBinding.loginViewModel = loginViewModel

        observer()
    }

    private fun observer() {

        lifecycleScopeCreate(activity = this, method = {

            loginViewModel.loginMutableStateFlow.collect { loginIntent ->

                LoginConfig.selectLoginIntent(loginIntent = loginIntent)
            }
        })
    }

    override fun message(idMessage: Int) {

        MessageUtil.message(activity = this, idMessage = idMessage)
    }
}