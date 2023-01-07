package com.leandro1995.retoandroid.model.entitie

import com.leandro1995.retoandroid.config.Setting
import com.leandro1995.retoandroid.retrofit.service.GetService
import com.leandro1995.retoandroid.retrofit.service.PostService

class User constructor(var document: String = "", var password: String = "") {

    fun isVerifyDocument(): Int {

        return when {

            isDocument() -> {

                Setting.MESSAGE_DOCUMENT
            }
            isPassword() -> {

                Setting.MESSAGE_PASSWORD
            }
            document != "77210641" -> {

                Setting.MESSAGE_DOCUMENT
            }
            password != "12345678Mn" -> {

                Setting.MESSAGE_PASSWORD
            }
            else -> {

                0
            }
        }
    }

    suspend fun login(response: () -> Unit) = PostService.login(response)


    suspend fun productList(response: (productArrayList: ArrayList<Product>) -> Unit) {

        val list = ArrayList<Product>()

        GetService.productList {

            it.forEach { productResponse ->

                list.add(
                    Product(
                        isType = productResponse.isType,
                        amount = productResponse.amount,
                        accountNumber = productResponse.accountNumber
                    )
                )
            }

            response(list)
        }
    }

    private fun isDocument() = document.isEmpty()

    private fun isPassword() = password.isEmpty()
}