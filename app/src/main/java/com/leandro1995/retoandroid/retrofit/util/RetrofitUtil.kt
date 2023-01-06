package com.leandro1995.retoandroid.retrofit.util

import com.leandro1995.retoandroid.retrofit.config.Setting
import java.net.SocketTimeoutException

class RetrofitUtil {

    companion object {

        fun exception(exception: Exception): Int {

            return when (exception) {

                is SocketTimeoutException -> {

                    Setting.INTERNET_TIME_OUT
                }
                else -> {

                    Setting.ERROR_SERVICE_514
                }
            }
        }
    }
}