package com.leandro1995.retoandroid.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.activity.DetailProductActivity
import com.leandro1995.retoandroid.config.Setting
import com.leandro1995.retoandroid.model.entitie.Product
import com.leandro1995.retoandroid.util.DesignUtil

class ProductAdapter constructor(
    private val activity: Activity, private val productArrayList: ArrayList<Product>
) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {

        return ProductHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductHolder, position: Int) {

        holder.apply {

            titleText.text =
                activity.getText(DesignUtil.titleCount(isType = productArrayList[position].isType))
            amountText.text =
                "${activity.getText(DesignUtil.moneySymbol(isType = productArrayList[position].isType))} ${productArrayList[position].amount}"
        }
    }

    override fun getItemCount(): Int {

        return productArrayList.size
    }

    inner class ProductHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        private val productCard: CardView = view.findViewById(R.id.productCard)
        val titleText: TextView = view.findViewById(R.id.titleText)
        val amountText: TextView = view.findViewById(R.id.amountText)

        init {

            productCard.setOnClickListener {

                activity.startActivity(Intent(activity, DetailProductActivity::class.java).apply {

                    putExtra(Setting.PRODUCT_PUT_EXTRA, productArrayList[adapterPosition])
                })
            }
        }
    }
}