package com.leandro1995.retoandroid.retrofit.model

import com.google.gson.annotations.SerializedName
import com.leandro1995.retoandroid.retrofit.config.Setting

class MovementProductResponse constructor(
    @SerializedName(Setting.TYPE) val type: String = "",
    @SerializedName(Setting.DATE) val date: String = "",
    @SerializedName(Setting.AMOUNT) val amount: Double = -1.0,
    @SerializedName(Setting.IS_DISCOUNT) val isDiscount: Boolean = false
)