package com.example.marsrobots.main

import com.example.marsrobots.base.BasePresenter
import com.example.marsrobots.data.Image
import com.example.marsrobots.data.ImageManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(private var imageManager: ImageManager) : BasePresenter<MainContract.View>(), MainContract.Presenter {
    override var view: MainContract.View? = null

    override fun publish() {
        disposables.add(imageManager.getImages()
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe({ list -> onSuccess(list) },
                                       { throwable ->
                                           view?.showErrorMessage(throwable.message ?: "")
                                       }))
    }

    private fun onSuccess(list: List<Image>) {
        if (list.isEmpty()) {
            view?.showErrorMessage("No item")
        } else {
            view?.showImages(list)
        }
    }
}