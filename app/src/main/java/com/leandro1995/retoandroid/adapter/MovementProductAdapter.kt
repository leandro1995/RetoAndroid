package com.leandro1995.retoandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.retoandroid.R

class MovementProductAdapter :
    RecyclerView.Adapter<MovementProductAdapter.MovementProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovementProductHolder {

        return MovementProductHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movement_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovementProductHolder, position: Int) {

    }

    override fun getItemCount(): Int {

        return 10
    }

    class MovementProductHolder constructor(view: View) : RecyclerView.ViewHolder(view)
}