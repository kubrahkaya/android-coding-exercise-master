package com.example.marsrobots.base

interface BaseContract {

    interface View {
        fun injectDependencies()
    }

    interface Presenter<V> {
        var view: V?

        fun takeView(view: V) {
            this.view = view
            publish()
        }

        fun dropView() {
            this.view = null
        }

        fun publish()
    }
}