package com.leandro1995.retoandroid.retrofit.service

import com.leandro1995.retoandroid.retrofit.config.RetrofitConfig
import com.leandro1995.retoandroid.retrofit.model.ProductResponse

class GetService {

    companion object {

        suspend fun productList(response: (productResponseArrayList: ArrayList<ProductResponse>) -> Unit) {

            try {

                RetrofitConfig.getApi.productArrayList().let {

                    if (it.isSuccessful) {

                        response(it.body()!!)
                    }
                }
            } catch (_: Exception) {

            }
        }
    }
}