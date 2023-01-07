package com.leandro1995.retoandroid.model.entitie

class MovementProduct constructor(
    val type: String = "",
    val date: String = "",
    val amount: Double = -1.0,
    val isDiscount: Boolean = false,
    val isTypeAccount: Boolean = false
)