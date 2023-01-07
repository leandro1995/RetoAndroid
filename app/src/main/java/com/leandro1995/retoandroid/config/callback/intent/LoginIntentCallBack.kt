package com.leandro1995.retoandroid.config.callback.intent

import com.leandro1995.retoandroid.config.callback.action.InternetCallBack

interface LoginIntentCallBack : InternetCallBack {

    fun message(idMessage: Int)

    fun listProductActivity()
}