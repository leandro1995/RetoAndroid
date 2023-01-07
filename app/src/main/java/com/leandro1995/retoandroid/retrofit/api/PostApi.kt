package com.leandro1995.retoandroid.retrofit.api

import com.leandro1995.retoandroid.retrofit.model.LoginResponse
import retrofit2.Response
import retrofit2.http.POST

interface PostApi {

    @POST("login")
    suspend fun login(): Response<LoginResponse>
}