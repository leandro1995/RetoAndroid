package com.leandro1995.retoandroid.activity

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.adapter.MovementProductAdapter
import com.leandro1995.retoandroid.background.TimeOutBackground
import com.leandro1995.retoandroid.config.Setting
import com.leandro1995.retoandroid.config.callback.intent.DetailProductIntentCallBack
import com.leandro1995.retoandroid.databinding.ActivityDetailProductBinding
import com.leandro1995.retoandroid.extension.lifecycleScopeCreate
import com.leandro1995.retoandroid.extension.putExtra
import com.leandro1995.retoandroid.model.desing.Progress
import com.leandro1995.retoandroid.model.entitie.MovementProduct
import com.leandro1995.retoandroid.util.DesignUtil
import com.leandro1995.retoandroid.viewmodel.DetailProductViewModel
import com.leandro1995.retoandroid.viewmodel.config.DetailProductConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailProductActivity : AppCompatActivity(), DetailProductIntentCallBack {

    private lateinit var detailProductBinding: ActivityDetailProductBinding

    private lateinit var detailProductViewModel: DetailProductViewModel

    private lateinit var movementProductAdapter: MovementProductAdapter

    private val movementProductArrayList = arrayListOf<MovementProduct>()

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

        movementProductAdapter =
            MovementProductAdapter(
                activity = this,
                movementProductArrayList = movementProductArrayList
            )

        detailProductBinding.apply {

            movementProductRecycler.apply {

                layoutManager = LinearLayoutManager(this@DetailProductActivity).apply {
                    orientation = LinearLayoutManager.VERTICAL
                }

                adapter = movementProductAdapter
            }

            detailProductViewModel!!.onClick.invoke(DetailProductViewModel.MOVEMENT_PRODUCT)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun movementProductArrayList(movementProductArrayList: ArrayList<MovementProduct>) {

        detailProductBinding.let {

            it.progressBar3.visibility = View.GONE
            it.motionProductLinear.visibility = View.VISIBLE
        }

        this.movementProductArrayList.clear()
        this.movementProductArrayList.addAll(movementProductArrayList)

        movementProductAdapter.notifyDataSetChanged()
    }

    override fun copy(accountNumber: String) {

        val clipBoardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText(getText(R.string.app_name), accountNumber)
        clipBoardManager.setPrimaryClip(clipData)

        Toast.makeText(this, getString(R.string.copy_account_number_message), Toast.LENGTH_SHORT)
            .show()
    }

    override fun progress(progress: Progress) {

        CoroutineScope(Dispatchers.Main).launch {

            detailProductViewModel.service(id = progress.id)
        }
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {

        TimeOutBackground.isTimeOut = true

        return super.dispatchTouchEvent(event)
    }
}