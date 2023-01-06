package com.leandro1995.retoandroid.retrofit.config

import com.leandro1995.retoandroid.BuildConfig
import com.leandro1995.retoandroid.retrofit.api.ServiceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    val serviceApi: ServiceApi = retrofit.create(ServiceApi::class.java)
}