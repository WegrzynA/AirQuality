package com.awegrzyn.airquality.ui.base

import android.support.v7.app.AppCompatActivity
import com.awegrzyn.airquality.ui.base.mvp.BaseInteractor
import com.awegrzyn.airquality.ui.base.mvp.BasePresenter
import com.awegrzyn.airquality.ui.base.mvp.BaseView

abstract class BaseActivity<T : BasePresenter<BaseView,BaseInteractor>>: AppCompatActivity() {

    lateinit var presenter: T

    abstract fun onCreatePresenter(): T

    override fun onResume() {
        super.onResume()
        presenter = onCreatePresenter()
        presenter.onCreate()
    }
}