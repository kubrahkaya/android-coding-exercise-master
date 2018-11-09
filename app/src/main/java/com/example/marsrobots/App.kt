package com.example.marsrobots

import android.app.Application
import android.content.Context
import com.example.marsrobots.data.source.local.ImageDao
import com.example.marsrobots.data.source.remote.ApiService
import com.example.marsrobots.di.components.AppComponent
import com.example.marsrobots.di.components.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent
    private lateinit var apiService: ApiService
    private lateinit var imageDao: ImageDao

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()

        apiService = appComponent.apiService
        imageDao = appComponent.imageDao
    }

    operator fun get(context: Context): App {
        return context.applicationContext as App
    }

    fun appComponent(): AppComponent = appComponent
}