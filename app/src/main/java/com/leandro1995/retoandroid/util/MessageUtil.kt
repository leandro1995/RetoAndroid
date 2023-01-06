package com.leandro1995.retoandroid.util

import android.app.Activity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.leandro1995.retoandroid.R

class MessageUtil {

    companion object {

        fun message(activity: Activity, idMessage: Int) {

            MaterialAlertDialogBuilder(activity).setMessage(activity.getString(idMessage))
                .setPositiveButton(activity.getString(R.string.accept_text_button), null).show()
        }
    }
}