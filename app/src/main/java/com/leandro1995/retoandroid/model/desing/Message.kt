package com.leandro1995.retoandroid.model.desing

import com.leandro1995.retoandroid.config.Setting

class Message constructor(private val id: Int) {

    fun idMessage() = Setting.messageHashMap[id]
}