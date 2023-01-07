package com.leandro1995.retoandroid.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandro1995.retoandroid.R
import com.leandro1995.retoandroid.adapter.ProductAdapter
import com.leandro1995.retoandroid.config.callback.intent.ListProductIntentCallBack
import com.leandro1995.retoandroid.databinding.FragmentListProductBinding
import com.leandro1995.retoandroid.extension.lifecycleScopeCreate
import com.leandro1995.retoandroid.model.desing.Progress
import com.leandro1995.retoandroid.model.entitie.Product
import com.leandro1995.retoandroid.util.DesignUtil
import com.leandro1995.retoandroid.util.ViewModelUtil
import com.leandro1995.retoandroid.viewmodel.ListProductViewModel
import com.leandro1995.retoandroid.viewmodel.config.ListProductConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListProductFragment : Fragment(), ListProductIntentCallBack {

    private lateinit var listProductBinding: FragmentListProductBinding

    private var listProductViewModel: ListProductViewModel? = null

    private lateinit var productAdapter: ProductAdapter

    private val productList = arrayListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        ViewModelUtil.viewModel(listProductViewModel = listProductViewModel) {

            ListProductConfig.instance(listProductIntentCallBack = this)

            listProductViewModel = ViewModelProvider(this)[ListProductViewModel::class.java]

            listProductBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_list_product, container, false)
            listProductBinding.listProductViewModel = listProductViewModel

            observer()
        }

        return listProductBinding.root
    }

    private fun observer() {

        lifecycleScopeCreate(activity = requireActivity(), method = {

            listProductViewModel!!.listProductMutableStateFlow.collect { listProductIntent ->

                ListProductConfig.selectListProductIntent(listProductIntent = listProductIntent)
            }
        })
    }

    override fun initView() {

        productAdapter =
            ProductAdapter(activity = requireActivity(), productArrayList = productList)

        listProductBinding.apply {

            DesignUtil.toolbar(
                activity = requireActivity(),
                toolbar = includeAppBar.toolbar,
                title = getString(R.string.product_title_text)
            )

            productRecycler.apply {

                layoutManager = LinearLayoutManager(requireActivity()).apply {
                    orientation = LinearLayoutManager.VERTICAL
                }

                adapter = productAdapter
            }

            productSwipe.setOnRefreshListener {

                listProductViewModel!!.onClick.invoke(ListProductViewModel.PRODUCT_ARRAY_LIST_SWIPE)
            }

            listProductViewModel!!.onClick.invoke(ListProductViewModel.PRODUCT_ARRAY_LIST)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun productArrayList(productArrayList: ArrayList<Product>) {

        listProductBinding.progressBar2.visibility = View.GONE
        listProductBinding.productSwipe.isRefreshing = false

        productList.clear()
        productList.addAll(productArrayList)

        productAdapter.notifyDataSetChanged()
    }

    override fun progress(progress: Progress) {

        DesignUtil.visibleProgress(isType = progress.isType, visible = {

            listProductBinding.progressBar2.visibility = it
        })

        CoroutineScope(Dispatchers.Main).launch {

            listProductViewModel!!.service(id = progress.id)
        }
    }
}