package com.leandro1995.retoandroid.retrofit.model

import com.google.gson.annotations.SerializedName
import com.leandro1995.retoandroid.retrofit.config.Setting

class LoginResponse constructor(
    @SerializedName(Setting.NAME) val name: String
)