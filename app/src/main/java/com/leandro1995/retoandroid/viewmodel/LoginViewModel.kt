package com.leandro1995.retoandroid.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.retoandroid.config.intent.InternetIntent
import com.leandro1995.retoandroid.intent.LoginIntent
import com.leandro1995.retoandroid.model.desing.Message
import com.leandro1995.retoandroid.model.desing.Progress
import com.leandro1995.retoandroid.model.entitie.User
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel() {

    companion object {

        const val LOGIN = 0
        private const val LOGIN_SERVICE = 1
    }

    val loginMutableStateFlow: MutableStateFlow<LoginIntent> by lazy {
        MutableStateFlow(LoginIntent.InitView)
    }

    val user = User()

    val onClick = fun(action: Int) {

        when (action) {

            LOGIN -> {

                verifyLogin()
            }
        }
    }

    suspend fun service(id: Int) {

        when (id) {

            LOGIN_SERVICE -> {

                user.login(response = {

                    loginMutableStateFlow.value = LoginIntent.ListProductActivity
                })
            }
        }
    }

    private fun verifyLogin() {

        loginMutableStateFlow.value = user.isVerifyDocument().let {

            if (it != 0) {

                LoginIntent.WarningMessage(message = Message(id = it))
            } else {

                LoginIntent.InternetStatus(InternetIntent.Progress(Progress(id = LOGIN_SERVICE)))
            }
        }
    }
}