package com.leandro1995.retoandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.adapter.MovementProductAdapter

class DetailProductActivity : AppCompatActivity() {

    private lateinit var movementProductAdapter: MovementProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        movementProductAdapter = MovementProductAdapter()

        findViewById<RecyclerView>(R.id.movementProductRecycler).apply {

            layoutManager = LinearLayoutManager(this@DetailProductActivity).apply {
                orientation = LinearLayoutManager.VERTICAL
            }

            adapter = movementProductAdapter
        }
    }
}