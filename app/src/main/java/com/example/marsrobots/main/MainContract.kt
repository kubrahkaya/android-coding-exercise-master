package com.example.marsrobots.main

import com.example.marsrobots.base.BaseContract
import com.example.marsrobots.data.Image

interface MainContract {

    interface View : BaseContract.View {
        fun showImages(content: List<Image>)
        fun showErrorMessage(errorMessage: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
    }
}