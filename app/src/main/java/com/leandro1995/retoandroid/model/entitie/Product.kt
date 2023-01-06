package com.leandro1995.retoandroid.model.entitie

import java.io.Serializable

class Product constructor(
    val isType: Boolean = false,
    val amount: Double = -1.0,
    val accountNumber: String = ""
) : Serializable
