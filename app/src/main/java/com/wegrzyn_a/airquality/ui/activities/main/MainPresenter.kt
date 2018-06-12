package com.wegrzyn_a.airquality.ui.activities.main

import android.util.Log
import com.github.mikephil.charting.data.Entry
import com.wegrzyn_a.airquality.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(val view: MainView): BasePresenter() {
    override fun onCreate() {
        MainInteractor()
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    view.loadData(it)
                },
                        {
                            Log.d("MainPreseter", "error:" + it.message);
                        })
//        view.loadData(mockEntries())
    }

    fun mockEntries() = listOf(Entry(1f,1f),Entry(2f,2f),Entry(3f,3f))

}