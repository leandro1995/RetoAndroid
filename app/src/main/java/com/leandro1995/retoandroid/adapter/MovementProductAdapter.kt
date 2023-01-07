package com.leandro1995.retoandroid.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.paris.extensions.style
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.model.entitie.MovementProduct
import com.leandro1995.retoandroid.util.DesignUtil

class MovementProductAdapter constructor(
    private val activity: Activity, private val movementProductArrayList: ArrayList<MovementProduct>
) : RecyclerView.Adapter<MovementProductAdapter.MovementProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovementProductHolder {

        return MovementProductHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movement_product, parent, false)
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MovementProductHolder, position: Int) {

        holder.apply {

            typeText.text = movementProductArrayList[position].type
            dateText.text = movementProductArrayList[position].date
            amountText.apply {

                text =
                    "${activity.getString(DesignUtil.discount(isType = movementProductArrayList[position].isDiscount))}${
                        activity.getString(DesignUtil.moneySymbol(isType = movementProductArrayList[position].isTypeAccount))
                    } ${movementProductArrayList[position].amount}"

                style(DesignUtil.discountStyle(isType = movementProductArrayList[position].isDiscount))
            }
        }
    }

    override fun getItemCount(): Int {

        return movementProductArrayList.size
    }

    class MovementProductHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        val typeText: TextView = view.findViewById(R.id.typeText)
        val dateText: TextView = view.findViewById(R.id.dateText)
        val amountText: TextView = view.findViewById(R.id.amountText)
    }
}