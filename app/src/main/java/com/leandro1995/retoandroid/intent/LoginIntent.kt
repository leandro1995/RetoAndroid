package com.leandro1995.retoandroid.intent

import com.leandro1995.retoandroid.config.intent.InternetIntent
import com.leandro1995.retoandroid.model.desing.Message

sealed class LoginIntent {

    object InitView : LoginIntent()

    object ListProductActivity : LoginIntent()

    data class WarningMessage constructor(val message: Message) : LoginIntent()

    data class InternetStatus constructor(val internetIntent: InternetIntent) : LoginIntent()
}