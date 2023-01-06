package com.leandro1995.retoandroid.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.adapter.ProductAdapter
import com.leandro1995.retoandroid.config.callback.intent.ListProductIntentCallBack
import com.leandro1995.retoandroid.databinding.ActivityListProductBinding
import com.leandro1995.retoandroid.extension.lifecycleScopeCreate
import com.leandro1995.retoandroid.model.desing.Progress
import com.leandro1995.retoandroid.model.entitie.Product
import com.leandro1995.retoandroid.util.DesignUtil
import com.leandro1995.retoandroid.viewmodel.ListProductViewModel
import com.leandro1995.retoandroid.viewmodel.config.ListProductConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListProductActivity : AppCompatActivity(), ListProductIntentCallBack {

    private lateinit var listProductBinding: ActivityListProductBinding

    private lateinit var listProductViewModel: ListProductViewModel

    private lateinit var productAdapter: ProductAdapter

    private val productList = arrayListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ListProductConfig.instance(listProductIntentCallBack = this)

        listProductViewModel = ViewModelProvider(this)[ListProductViewModel::class.java]

        listProductBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_product)
        listProductBinding.listProductViewModel = listProductViewModel

        observer()
    }

    private fun observer() {

        lifecycleScopeCreate(activity = this, method = {

            listProductViewModel.listProductMutableStateFlow.collect { listProductIntent ->

                ListProductConfig.selectListProductIntent(listProductIntent = listProductIntent)
            }
        })
    }

    override fun initView() {

        productAdapter = ProductAdapter(activity = this, productArrayList = productList)

        listProductBinding.apply {

            productRecycler.apply {

                layoutManager = LinearLayoutManager(this@ListProductActivity).apply {
                    orientation = LinearLayoutManager.VERTICAL
                }

                adapter = productAdapter
            }

            listProductViewModel!!.onClick.invoke(ListProductViewModel.PRODUCT_ARRAY_LIST)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun productArrayList(productArrayList: ArrayList<Product>) {

        listProductBinding.progressBar2.visibility = View.GONE

        productList.clear()
        productList.addAll(productArrayList)

        productAdapter.notifyDataSetChanged()
    }

    override fun progress(progress: Progress) {

        DesignUtil.visibleProgress(isType = progress.isType, visible = {

            listProductBinding.progressBar2.visibility = it
        })

        CoroutineScope(Dispatchers.Main).launch {

            listProductViewModel.service(id = progress.id)
        }
    }
}