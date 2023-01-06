package com.leandro1995.retoandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.retoandroid.R

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

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

    class ProductHolder constructor(view: View) : RecyclerView.ViewHolder(view)
}