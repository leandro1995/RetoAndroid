package com.leandro1995.retoandroid.viewmodel

import androidx.lifecycle.ViewModel
import com.leandro1995.retoandroid.intent.DetailProductIntent
import com.leandro1995.retoandroid.model.entitie.Product
import kotlinx.coroutines.flow.MutableStateFlow

class DetailProductViewModel : ViewModel() {

    val detailProductMutableStateFlow: MutableStateFlow<DetailProductIntent> by lazy {
        MutableStateFlow(DetailProductIntent.InitView)
    }

    lateinit var product: Product
}