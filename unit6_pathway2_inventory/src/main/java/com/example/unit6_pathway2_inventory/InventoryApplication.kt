package com.example.unit6_pathway2_inventory

import android.app.Application
import com.example.unit6_pathway2_inventory.data.AppContainer
import com.example.unit6_pathway2_inventory.data.AppDataContainer

class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}