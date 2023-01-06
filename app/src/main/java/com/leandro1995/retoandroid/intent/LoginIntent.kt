package com.leandro1995.retoandroid.intent

import com.leandro1995.retoandroid.model.desing.Message

sealed class LoginIntent {

    object InitView : LoginIntent()

    data class WarningMessage constructor(val message: Message) : LoginIntent()
}