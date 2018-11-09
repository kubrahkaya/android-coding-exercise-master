package com.example.marsrobots.main

import android.os.Bundle
import com.example.marsrobots.R
import com.example.marsrobots.base.BaseActivity
import com.example.marsrobots.data.Image

class MainActivity : BaseActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {

    override fun injectDependencies() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showImages(content: List<Image>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorMessage(errorMessage: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
