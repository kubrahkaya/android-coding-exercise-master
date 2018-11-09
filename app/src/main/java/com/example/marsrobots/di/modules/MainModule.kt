package com.example.marsrobots.di.modules

import android.content.Context
import com.example.marsrobots.di.qualifiers.ActivityContext
import com.example.marsrobots.di.scopes.PerActivity
import com.example.marsrobots.main.MainActivity
import com.example.marsrobots.main.MainContract
import com.example.marsrobots.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule(private val mainActivity: MainActivity) {

    @PerActivity
    @Provides
    internal fun provideMainActivity(): MainActivity = mainActivity

    @PerActivity
    @Provides
    @ActivityContext
    internal fun providesContext(): Context = mainActivity

    @PerActivity
    @Provides
    internal fun providePresenter(presenter: MainPresenter): MainContract.Presenter = presenter
}