package com.leandro1995.retoandroid.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.retoandroid.intent.LoginIntent
import com.leandro1995.retoandroid.model.entitie.User
import com.leandro1995.retoandroid.model.desing.Message
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : ViewModel() {

    companion object {

        const val LOGIN = 0
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

    private fun verifyLogin() {

        loginMutableStateFlow.value = user.isVerifyDocument().let {

            if (it != 0) {

                LoginIntent.WarningMessage(message = Message(id = it))
            } else {

                LoginIntent.InitView
            }
        }
    }
}