package com.leandro1995.retoandroid.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.retoandroid.config.intent.InternetIntent
import com.leandro1995.retoandroid.intent.DetailProductIntent
import com.leandro1995.retoandroid.model.desing.Progress
import com.leandro1995.retoandroid.model.entitie.Product
import com.leandro1995.retoandroid.retrofit.model.MovementProductResponse
import kotlinx.coroutines.flow.MutableStateFlow

class DetailProductViewModel : ViewModel() {

    companion object {

        const val MOVEMENT_PRODUCT = 0
        const val COPY = 1
        const val MOVEMENT_PRODUCT_SERVICE = 2
    }

    val detailProductMutableStateFlow: MutableStateFlow<DetailProductIntent> by lazy {
        MutableStateFlow(DetailProductIntent.InitView)
    }

    lateinit var product: Product

    val onClick = fun(action: Int) {

        when (action) {

            MOVEMENT_PRODUCT -> {

                movementProduct()
            }
            COPY -> {

                copy()
            }
        }
    }

    suspend fun service(id: Int) {

        when (id) {

            MOVEMENT_PRODUCT_SERVICE -> {

                product.movementProductList {

                    detailProductMutableStateFlow.value =
                        DetailProductIntent.MovementProductArrayList(movementProductArrayList = it)
                }
            }
        }
    }

    private fun movementProduct() {

        detailProductMutableStateFlow.value =
            DetailProductIntent.InternetStatus(InternetIntent.Progress(progress = Progress(id = MOVEMENT_PRODUCT_SERVICE)))
    }

    private fun copy() {

        detailProductMutableStateFlow.value =
            DetailProductIntent.Copy(accountNumber = product.accountNumber)
    }
}