package com.example.marsrobots.base

import io.reactivex.disposables.CompositeDisposable

abstract class  BasePresenter<V> : BaseContract.Presenter<V> {

    internal val disposables = CompositeDisposable()

    override fun dropView() {
        super.dropView()
        disposables.clear()
    }
}