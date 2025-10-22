package com.example.unit7_pathway1_bluromatic

import android.app.Application
import com.example.unit7_pathway1_bluromatic.data.AppContainer
import com.example.unit7_pathway1_bluromatic.data.DefaultAppContainer

class BluromaticApplication : Application()  {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}
