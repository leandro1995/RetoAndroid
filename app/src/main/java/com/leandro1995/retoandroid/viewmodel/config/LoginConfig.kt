package com.leandro1995.retoandroid.viewmodel.config

import com.leandro1995.retoandroid.config.callback.intent.LoginIntentCallBack
import com.leandro1995.retoandroid.config.intent.InternetIntent
import com.leandro1995.retoandroid.intent.LoginIntent

object LoginConfig {

    private lateinit var loginIntentCallBack: LoginIntentCallBack

    fun instance(loginIntentCallBack: LoginIntentCallBack) {

        this.loginIntentCallBack = loginIntentCallBack
    }

    fun selectLoginIntent(loginIntent: LoginIntent) {

        when (loginIntent) {

            LoginIntent.InitView -> {

            }
            is LoginIntent.WarningMessage -> {

                loginIntentCallBack.message(idMessage = loginIntent.message.idMessage()!!)
            }
            is LoginIntent.InternetStatus -> {

                when (loginIntent.internetIntent) {

                    is InternetIntent.Progress -> {

                        loginIntentCallBack.progress(progress = loginIntent.internetIntent.progress)
                    }
                }
            }
            LoginIntent.ListProductActivity -> {

                loginIntentCallBack.listProductActivity()
            }
        }
    }
}