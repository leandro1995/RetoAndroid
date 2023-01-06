package com.leandro1995.retoandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.adapter.ProductAdapter

class ListProductActivity : AppCompatActivity() {

    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_product)

        productAdapter = ProductAdapter()

        findViewById<RecyclerView>(R.id.productRecycler).apply {

            layoutManager = LinearLayoutManager(this@ListProductActivity).apply {
                orientation = LinearLayoutManager.VERTICAL
            }

            adapter = productAdapter
        }
    }
}