package com.leandro1995.retoandroid.intent

import com.leandro1995.retoandroid.config.intent.InternetIntent
import com.leandro1995.retoandroid.model.entitie.MovementProduct

sealed class DetailProductIntent {

    object InitView : DetailProductIntent()

    data class InternetStatus constructor(val internetIntent: InternetIntent) :
        DetailProductIntent()

    data class MovementProductArrayList constructor(val movementProductArrayList: ArrayList<MovementProduct>) :
        DetailProductIntent()
}