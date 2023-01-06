package com.leandro1995.retoandroid.retrofit.model

import com.google.gson.annotations.SerializedName
import com.leandro1995.retoandroid.retrofit.config.Setting

class ProductResponse constructor(
    @SerializedName(Setting.TYPE) val isType: Boolean = false,
    @SerializedName(Setting.AMOUNT) val amount: Double = -1.0,
    @SerializedName(Setting.ACCOUNT_NUMBER) val accountNumber: String = ""
)