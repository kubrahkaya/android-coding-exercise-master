package com.example.marsrobots.di.components

import android.content.Context
import com.example.marsrobots.data.source.local.ImageDao
import com.example.marsrobots.data.source.remote.ApiService
import com.example.marsrobots.di.modules.AppModule
import com.example.marsrobots.di.modules.MainModule
import com.example.marsrobots.di.qualifiers.ApplicationContext
import com.example.marsrobots.di.scopes.PerApplication
import dagger.Component

@PerApplication
@Component(modules = [(AppModule::class), (MainModule::class)])
interface AppComponent {

    val apiService: ApiService
    val imageDao: ImageDao
    @ApplicationContext
    fun context(): Context
}