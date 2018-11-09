package com.example.marsrobots.di.components

import com.example.marsrobots.di.modules.MainModule
import com.example.marsrobots.di.scopes.PerActivity
import com.example.marsrobots.main.MainActivity
import dagger.Component

@PerActivity
@Component(modules = [(MainModule::class)], dependencies = [(AppComponent::class)])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}