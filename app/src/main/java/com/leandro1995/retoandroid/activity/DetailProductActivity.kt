package com.leandro1995.retoandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.adapter.MovementProductAdapter
import com.leandro1995.retoandroid.config.Setting
import com.leandro1995.retoandroid.config.callback.intent.DetailProductIntentCallBack
import com.leandro1995.retoandroid.databinding.ActivityDetailProductBinding
import com.leandro1995.retoandroid.extension.lifecycleScopeCreate
import com.leandro1995.retoandroid.extension.putExtra
import com.leandro1995.retoandroid.model.desing.Progress
import com.leandro1995.retoandroid.util.DesignUtil
import com.leandro1995.retoandroid.viewmodel.DetailProductViewModel
import com.leandro1995.retoandroid.viewmodel.config.DetailProductConfig
import com.leandro1995.retoandroid.viewmodel.config.LoginConfig

class DetailProductActivity : AppCompatActivity(), DetailProductIntentCallBack {

    private lateinit var detailProductBinding: ActivityDetailProductBinding

    private lateinit var detailProductViewModel: DetailProductViewModel

    private lateinit var movementProductAdapter: MovementProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DetailProductConfig.instance(detailProductIntentCallBack = this)

        detailProductViewModel = ViewModelProvider(this)[DetailProductViewModel::class.java]

        detailProductBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail_product)
        detailProductBinding.detailProductViewModel = detailProductViewModel

        detailProductViewModel.product = (Setting.PRODUCT_PUT_EXTRA putExtra this)!!

        observer()
    }

    private fun observer() {

        lifecycleScopeCreate(activity = this, method = {

            detailProductViewModel.detailProductMutableStateFlow.collect { detailProductIntent ->

                DetailProductConfig.selectDetailProduct(detailProductIntent = detailProductIntent)
            }
        })
    }

    override fun initView() {

        DesignUtil.viewDetailProduct(activity = this, detailProductBinding = detailProductBinding)

        movementProductAdapter = MovementProductAdapter()

        detailProductBinding.movementProductRecycler.apply {

            layoutManager = LinearLayoutManager(this@DetailProductActivity).apply {
                orientation = LinearLayoutManager.VERTICAL
            }

            adapter = movementProductAdapter
        }
    }

    override fun progress(progress: Progress) {

    }
}