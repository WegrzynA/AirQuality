package com.wegrzyn_a.airquality.ui.base

import android.support.v7.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    lateinit var presenter: BasePresenter

    abstract fun onCreatePresenter(): BasePresenter

    override fun onResume() {
        super.onResume()
        presenter = onCreatePresenter()
        presenter.onCreate()
    }
}