package com.wegrzyn_a.airquality.ui.base

import android.support.v7.app.AppCompatActivity
import com.wegrzyn_a.airquality.ui.base.mvp.BaseInteractor
import com.wegrzyn_a.airquality.ui.base.mvp.BasePresenter
import com.wegrzyn_a.airquality.ui.base.mvp.BaseView

abstract class BaseActivity: AppCompatActivity() {

    lateinit var presenter: BasePresenter<BaseView,BaseInteractor>

    abstract fun onCreatePresenter(): BasePresenter<BaseView,BaseInteractor>

    override fun onResume() {
        super.onResume()
        presenter = onCreatePresenter()
        presenter.onCreate()
    }
}