package com.leandro1995.retoandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.leandro1995.retoandroid.activity.HomeActivity
import com.leandro1995.retoandroid.background.TimeOutBackground
import com.leandro1995.retoandroid.config.callback.intent.LoginIntentCallBack
import com.leandro1995.retoandroid.databinding.ActivityLoginBinding
import com.leandro1995.retoandroid.extension.lifecycleScopeCreate
import com.leandro1995.retoandroid.model.desing.Progress
import com.leandro1995.retoandroid.util.MessageUtil
import com.leandro1995.retoandroid.viewmodel.LoginViewModel
import com.leandro1995.retoandroid.viewmodel.config.LoginConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

    override fun listProductActivity() {

        TimeOutBackground.start()

        startActivity(Intent(this, HomeActivity::class.java))
        finishAffinity()
    }

    override fun progress(progress: Progress) {

        loginBinding.progressBar.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.Main).launch {

            loginViewModel.service(id = progress.id)
        }
    }
}