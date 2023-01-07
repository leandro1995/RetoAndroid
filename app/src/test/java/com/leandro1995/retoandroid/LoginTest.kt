package com.leandro1995.retoandroid

import com.leandro1995.retoandroid.intent.LoginIntent
import com.leandro1995.retoandroid.viewmodel.LoginViewModel
import org.junit.Assert.assertEquals
import org.junit.Test

class LoginTest {

    private val loginViewModel = LoginViewModel()

    @Test
    fun isDocument() {

        loginViewModel.apply {

            user.apply {

                document = ""
                password = ""
            }

            onClick.invoke(LoginViewModel.LOGIN)
        }

        assertEquals(
            R.string.message_login_verify_user,
            (loginViewModel.loginMutableStateFlow.value as LoginIntent.WarningMessage).message.idMessage()
        )
    }

    @Test
    fun isPassword() {

        loginViewModel.apply {

            user.apply {

                document = "7210641"
                password = ""
            }

            onClick.invoke(LoginViewModel.LOGIN)
        }

        assertEquals(
            R.string.message_login_verify_user,
            (loginViewModel.loginMutableStateFlow.value as LoginIntent.WarningMessage).message.idMessage()
        )
    }

    @Test
    fun verifyDocument() {

        loginViewModel.apply {

            user.apply {

                document = "7210661"
                password = "123848545"
            }

            onClick.invoke(LoginViewModel.LOGIN)
        }

        assertEquals(
            R.string.message_login_verify_user,
            (loginViewModel.loginMutableStateFlow.value as LoginIntent.WarningMessage).message.idMessage()
        )
    }

    @Test
    fun verifyPassword() {

        loginViewModel.apply {

            user.apply {

                document = "7210641"
                password = "123848545"
            }

            onClick.invoke(LoginViewModel.LOGIN)
        }

        assertEquals(
            R.string.message_login_verify_user,
            (loginViewModel.loginMutableStateFlow.value as LoginIntent.WarningMessage).message.idMessage()
        )
    }
}