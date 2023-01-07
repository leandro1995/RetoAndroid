package com.leandro1995.retoandroid.util

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.widget.ProgressBar
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.databinding.ActivityDetailProductBinding
import com.leandro1995.retoandroid.model.entitie.Product

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

        fun discount(isType: Boolean) = if (isType) {

            R.string.discount_minor_text
        } else {

            R.string.discount_more_text
        }

        fun visibleProgress(isType: Boolean, visible: (status: Int) -> Unit) {

            visible(
                if (isType) {

                    View.VISIBLE
                } else {

                    View.GONE
                }
            )
        }

        @SuppressLint("SetTextI18n")
        fun viewDetailProduct(
            activity: Activity, detailProductBinding: ActivityDetailProductBinding
        ) {

            detailProductBinding.let { detailProduct ->

                detailProduct.accountText.text =
                    activity.getText(titleCount(isType = detailProduct.detailProductViewModel!!.product.isType))

                detailProduct.amountText.text =
                    "${activity.getText(moneySymbol(isType = detailProduct.detailProductViewModel!!.product.isType))} ${detailProduct.detailProductViewModel!!.product.amount}"
            }
        }
    }
}