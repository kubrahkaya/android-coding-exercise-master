package com.example.marsrobots.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> : AppCompatActivity(), BaseContract.View {

    @Inject protected lateinit var presenter: P
    protected lateinit var disposables: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        disposables = CompositeDisposable()
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        presenter.takeView(this as V)
        super.onStart()
    }

    override fun onStop() {
        disposables.clear()
        presenter.dropView()
        super.onStop()
    }
}