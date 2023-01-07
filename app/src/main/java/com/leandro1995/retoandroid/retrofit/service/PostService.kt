package com.leandro1995.retoandroid.retrofit.service

import com.leandro1995.retoandroid.retrofit.config.RetrofitConfig

class PostService {

    companion object {

        suspend fun login(response: () -> Unit) {

            try {

                RetrofitConfig.postApi.login().let {

                    if (it.isSuccessful) {

                        response()
                    }
                }
            } catch (_: Exception) {

            }
        }
    }
}