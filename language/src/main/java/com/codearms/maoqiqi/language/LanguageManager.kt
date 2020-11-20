package com.codearms.maoqiqi.language

import android.app.Application

object LanguageManager {

//    companion object {
//
//        fun init(application: Application): LanguageManager {
//            return LanguageManager()
//        }
//    }

    fun init(application: Application) {
        application.registerActivityLifecycleCallbacks(LanguageLifecycleCallbacks {

        })
        application.registerComponentCallbacks(LanguageComponentCallbacks {

        })
    }
}