package com.leandro1995.retoandroid.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.activity.DetailProductActivity

class ProductAdapter constructor(private val activity: Activity) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {

        return ProductHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {

    }

    override fun getItemCount(): Int {

        return 10
    }

    inner class ProductHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        private val productCard: CardView = view.findViewById(R.id.productCard)

        init {

            productCard.setOnClickListener {

                activity.startActivity(Intent(activity, DetailProductActivity::class.java))
            }
        }
    }
}