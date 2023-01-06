package com.leandro1995.retoandroid.retrofit.api

import com.leandro1995.retoandroid.retrofit.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface GetApi {

    @GET("listProduct")
    suspend fun productArrayList(): Response<ArrayList<ProductResponse>>
}