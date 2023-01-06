package com.leandro1995.retoandroid.viewmodel.config

import com.leandro1995.retoandroid.config.callback.intent.ListProductIntentCallBack
import com.leandro1995.retoandroid.config.intent.InternetIntent
import com.leandro1995.retoandroid.intent.ListProductIntent

object ListProductConfig {

    private lateinit var listProductIntentCallBack: ListProductIntentCallBack

    fun instance(listProductIntentCallBack: ListProductIntentCallBack) {

        this.listProductIntentCallBack = listProductIntentCallBack
    }

    fun selectListProductIntent(listProductIntent: ListProductIntent) {

        when (listProductIntent) {

            ListProductIntent.InitView -> {

                listProductIntentCallBack.initView()
            }
            is ListProductIntent.InternetStatus -> {

                when (listProductIntent.internetIntent) {

                    is InternetIntent.Progress -> {

                        listProductIntentCallBack.progress(progress = listProductIntent.internetIntent.progress)
                    }
                }
            }
            is ListProductIntent.ProductArrayList -> {

                listProductIntentCallBack.productArrayList(productArrayList = listProductIntent.productArrayList)
            }
        }
    }
}