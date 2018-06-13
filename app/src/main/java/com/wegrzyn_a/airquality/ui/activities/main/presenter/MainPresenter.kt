package com.wegrzyn_a.airquality.ui.activities.main.presenter

import android.util.Log
import com.github.mikephil.charting.data.Entry
import com.wegrzyn_a.airquality.ui.activities.main.view.MainView
import com.wegrzyn_a.airquality.ui.activities.main.interactor.IMainInteractor
import com.wegrzyn_a.airquality.ui.base.mvp.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(view: MainView, interactor: IMainInteractor): BasePresenter<MainView, IMainInteractor>(view,interactor) {
    override fun onCreate() {

        view.onStartLoading()

        interactor
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    view.onLoadFinished(it)
                },
                        {
                            view.onLoadError(it.message ?: "loading error")
                            Log.d("MainPreseter", "error:" + it.message);
                        })
//        view.onLoadFinished(mockEntries())
    }

    fun mockEntries() = listOf(Entry(1f,1f),Entry(2f,2f),Entry(3f,3f))

}