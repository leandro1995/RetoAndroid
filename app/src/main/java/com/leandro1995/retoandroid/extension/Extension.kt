package com.leandro1995.retoandroid.extension

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.leandro1995.retoandroid.model.entitie.Product
import kotlinx.coroutines.launch

fun lifecycleScopeCreate(activity: Activity, method: suspend () -> Unit) =

    (activity as AppCompatActivity).lifecycleScope.launch {

        activity.repeatOnLifecycle(Lifecycle.State.CREATED) {

            method()
        }
    }

@Suppress("DEPRECATION")
infix fun String.putExtra(activity: Activity) =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

        activity.intent.extras!!.getSerializable(this, Product::class.java)
    } else {

        activity.intent.extras!!.getSerializable(this) as Product
    }