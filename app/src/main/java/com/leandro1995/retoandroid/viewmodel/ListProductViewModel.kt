package com.leandro1995.retoandroid.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.retoandroid.config.intent.InternetIntent
import com.leandro1995.retoandroid.intent.ListProductIntent
import com.leandro1995.retoandroid.model.desing.Progress
import com.leandro1995.retoandroid.model.entitie.User
import kotlinx.coroutines.flow.MutableStateFlow

class ListProductViewModel : ViewModel() {

    companion object {

        const val PRODUCT_ARRAY_LIST = 0
        const val PRODUCT_ARRAY_LIST_SWIPE = 1
        const val PRODUCT_ARRAY_LIST_SERVICE = 2
    }

    val listProductMutableStateFlow: MutableStateFlow<ListProductIntent> by lazy {
        MutableStateFlow(ListProductIntent.InitView)
    }

    private val user = User()

    val onClick = fun(action: Int) {

        when (action) {

            PRODUCT_ARRAY_LIST -> {

                productArrayList()
            }
            PRODUCT_ARRAY_LIST_SWIPE -> {

                productArrayListSwipe()
            }
        }
    }

    suspend fun service(id: Int) {

        when (id) {

            PRODUCT_ARRAY_LIST_SERVICE -> {

                user.productList {

                    listProductMutableStateFlow.value =
                        ListProductIntent.ProductArrayList(productArrayList = it)
                }
            }
        }
    }

    private fun productArrayList() {

        listProductMutableStateFlow.value =
            ListProductIntent.InternetStatus(
                InternetIntent.Progress(
                    progress = Progress(
                        id = PRODUCT_ARRAY_LIST_SERVICE,
                        isType = true
                    )
                )
            )
    }

    private fun productArrayListSwipe() {

        listProductMutableStateFlow.value =
            ListProductIntent.InternetStatus(
                InternetIntent.Progress(
                    progress = Progress(
                        id = PRODUCT_ARRAY_LIST_SERVICE,
                        isType = false
                    )
                )
            )
    }
}