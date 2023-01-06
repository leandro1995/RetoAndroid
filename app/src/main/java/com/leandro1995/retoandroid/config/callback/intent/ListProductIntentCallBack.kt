package com.leandro1995.retoandroid.config.callback.intent

import com.leandro1995.retoandroid.config.callback.action.InternetCallBack
import com.leandro1995.retoandroid.model.entitie.Product

interface ListProductIntentCallBack : InternetCallBack {

    fun initView()

    fun productArrayList(productArrayList: ArrayList<Product>)
}