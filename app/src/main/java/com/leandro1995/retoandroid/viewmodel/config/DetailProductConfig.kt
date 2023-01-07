package com.leandro1995.retoandroid.viewmodel.config

import com.leandro1995.retoandroid.config.callback.intent.DetailProductIntentCallBack
import com.leandro1995.retoandroid.config.intent.InternetIntent
import com.leandro1995.retoandroid.intent.DetailProductIntent

object DetailProductConfig {

    private lateinit var detailProductIntentCallBack: DetailProductIntentCallBack

    fun instance(detailProductIntentCallBack: DetailProductIntentCallBack) {

        this.detailProductIntentCallBack = detailProductIntentCallBack
    }

    fun selectDetailProduct(detailProductIntent: DetailProductIntent) {

        when (detailProductIntent) {

            DetailProductIntent.InitView -> {

                detailProductIntentCallBack.initView()
            }
            is DetailProductIntent.InternetStatus -> {

                when (detailProductIntent.internetIntent) {

                    is InternetIntent.Progress -> {

                        detailProductIntentCallBack.progress(progress = detailProductIntent.internetIntent.progress)
                    }
                }
            }
            is DetailProductIntent.MovementProductArrayList -> {

                detailProductIntentCallBack.movementProductArrayList(movementProductArrayList = detailProductIntent.movementProductArrayList)
            }
        }
    }
}