package com.leandro1995.retoandroid.util

import com.leandro1995.retoandroid.viewmodel.ListProductViewModel

class ViewModelUtil {

    companion object {

        fun viewModel(listProductViewModel: ListProductViewModel?, create: () -> Unit) {

            if (listProductViewModel == null) {

                create()
            }
        }
    }
}