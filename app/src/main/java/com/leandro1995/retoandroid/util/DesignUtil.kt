package com.leandro1995.retoandroid.util

import com.leandro1995.retoandroid.R

class DesignUtil {

    companion object {

        fun titleCount(isType: Boolean) = if (isType) {

            R.string.count_soles_text
        } else {

            R.string.count_dollar_text
        }

        fun moneySymbol(isType: Boolean) = if (isType) {

            R.string.symbol_soles_text
        } else {

            R.string.symbol_dollar_text
        }
    }
}