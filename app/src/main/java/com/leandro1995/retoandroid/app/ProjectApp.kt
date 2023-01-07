package com.leandro1995.retoandroid.app

import android.app.Application
import com.leandro1995.retoandroid.background.TimeOutBackground

class ProjectApp : Application() {

    override fun onCreate() {
        super.onCreate()

        TimeOutBackground.instance(context = this)
    }
}