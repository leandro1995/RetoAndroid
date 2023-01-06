package com.leandro1995.retoandroid.retrofit.service

import android.util.Log
import com.leandro1995.retoandroid.retrofit.config.RetrofitConfig
import com.leandro1995.retoandroid.retrofit.util.RetrofitUtil

class PostService {

    companion object {

        suspend fun login(response: () -> Unit) {

            try {

                RetrofitConfig.serviceApi.login().let {

                    if (it.isSuccessful) {

                        response()
                    }
                }
            } catch (_: Exception) {

            }
        }
    }
}