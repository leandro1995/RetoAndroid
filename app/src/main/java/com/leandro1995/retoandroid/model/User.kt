package com.leandro1995.retoandroid.model

class User constructor(private val document: String = "", private val password: String = "") {

    fun isVerifyDocument(): Int {

        return when {

            isDocument() -> {
                0
            }
            isPassword() -> {
                1
            }
            else -> {
                2
            }
        }
    }

    private fun isDocument() = document.isEmpty()

    private fun isPassword() = password.isEmpty()
}