package com.leandro1995.retoandroid.model.entitie

import com.leandro1995.retoandroid.retrofit.service.GetService
import java.io.Serializable

class Product constructor(
    val isType: Boolean = false,
    val amount: Double = -1.0,
    val accountNumber: String = ""
) : Serializable {

    suspend fun movementProductList(response: (productArrayList: ArrayList<MovementProduct>) -> Unit) {

        val list = arrayListOf<MovementProduct>()

        GetService.movementProductList {

            it.forEach { movementProductResponse ->

                list.add(
                    MovementProduct(
                        type = movementProductResponse.type,
                        date = movementProductResponse.date,
                        amount = movementProductResponse.amount,
                        isDiscount = movementProductResponse.isDiscount,
                        isTypeAccount = isType
                    )
                )
            }

            response(list)
        }
    }
}
