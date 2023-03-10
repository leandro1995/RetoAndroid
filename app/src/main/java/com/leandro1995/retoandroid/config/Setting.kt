package com.leandro1995.retoandroid.config

import com.leandro1995.retoandroid.R

class Setting {

    companion object {

        const val MESSAGE_DOCUMENT = -1
        const val MESSAGE_PASSWORD = -2

        val messageHashMap: HashMap<Int, Int> =
            hashMapOf(
                Pair(MESSAGE_DOCUMENT, R.string.message_login_verify_user),
                Pair(MESSAGE_PASSWORD, R.string.message_login_verify_user)
            )

        const val PRODUCT_PUT_EXTRA = "product_put_extra"
    }
}