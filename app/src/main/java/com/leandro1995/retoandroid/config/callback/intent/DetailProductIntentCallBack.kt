package com.leandro1995.retoandroid.config.callback.intent

import com.leandro1995.retoandroid.config.callback.action.InternetCallBack
import com.leandro1995.retoandroid.model.entitie.MovementProduct

interface DetailProductIntentCallBack : InternetCallBack {

    fun initView()

    fun movementProductArrayList(movementProductArrayList: ArrayList<MovementProduct>)
}