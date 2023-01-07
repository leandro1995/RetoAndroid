package com.leandro1995.retoandroid.intent

import com.leandro1995.retoandroid.model.entitie.Product

sealed class DetailProductIntent {

    object InitView : DetailProductIntent()
}