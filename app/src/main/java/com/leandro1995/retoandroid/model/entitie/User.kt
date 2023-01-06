package com.leandro1995.retoandroid.model.entitie

import com.leandro1995.retoandroid.config.Setting
import com.leandro1995.retoandroid.retrofit.service.PostService

class User constructor(var document: String = "", var password: String = "") {

    fun isVerifyDocument(): Int {

        return when {

            isDocument() -> {

                Setting.MESSAGE_NAME
            }
            isPassword() -> {

                Setting.MESSAGE_PASSWORD
            }
            else -> {
                0
            }
        }
    }

    suspend fun login(response: () -> Unit) =
        PostService.login(response)


    private fun isDocument() = document.isEmpty()

    private fun isPassword() = password.isEmpty()
}