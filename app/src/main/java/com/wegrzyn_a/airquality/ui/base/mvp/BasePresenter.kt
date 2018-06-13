package com.wegrzyn_a.airquality.ui.base.mvp

abstract class BasePresenter<out T: BaseView,out R: BaseInteractor>(val view: T, val interactor: R) {
    abstract fun onCreate()
}