package com.leandro1995.retoandroid.intent

import com.leandro1995.retoandroid.config.intent.InternetIntent
import com.leandro1995.retoandroid.model.entitie.Product

sealed class ListProductIntent {

    object InitView : ListProductIntent()

    data class InternetStatus constructor(val internetIntent: InternetIntent) : ListProductIntent()

    data class ProductArrayList constructor(val productArrayList: ArrayList<Product>) : ListProductIntent()
}
