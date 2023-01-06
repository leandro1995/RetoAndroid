package com.leandro1995.retoandroid.extension

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

fun lifecycleScopeCreate(activity: Activity, method: suspend () -> Unit) =

    (activity as AppCompatActivity).lifecycleScope.launch {

        activity.repeatOnLifecycle(Lifecycle.State.CREATED) {

            method()
        }
    }