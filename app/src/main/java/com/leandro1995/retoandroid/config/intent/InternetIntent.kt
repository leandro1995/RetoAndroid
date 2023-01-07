package com.leandro1995.retoandroid.config.intent

sealed class InternetIntent {

    data class Progress constructor(val progress: com.leandro1995.retoandroid.model.desing.Progress) :
        InternetIntent()
}
