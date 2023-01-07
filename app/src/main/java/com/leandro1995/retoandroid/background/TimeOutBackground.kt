package com.leandro1995.retoandroid.background

import android.content.Context
import android.content.Intent
import com.leandro1995.retoandroid.LoginActivity
import com.leandro1995.retoandroid.config.callback.intent.TimeOutBackgroundCallBack
import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

object TimeOutBackground {

    private lateinit var timeOutBackgroundCallBack: TimeOutBackgroundCallBack

    private const val TIME_OUT = 2L
    var isTimeOut = false

    fun instance(context: Context) {

        timeOutBackgroundCallBack = object : TimeOutBackgroundCallBack {

            override fun loginActivity() {

                context.startActivity(Intent(context, LoginActivity::class.java).apply {

                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                })
            }
        }
    }

    fun start() = CoroutineScope(Dispatchers.Main).launch {

        while (true) {

            delay(TimeUnit.SECONDS.toMillis(TIME_OUT))

            if (!isTimeOut) {

                timeOutBackgroundCallBack.loginActivity()
                cancel()
            } else {

                isTimeOut = false
            }
        }
    }
}