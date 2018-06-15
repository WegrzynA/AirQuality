package com.wegrzyn_a.airquality.ui.activities.main.presenter

import android.util.Log
import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementStationEntity
import com.wegrzyn_a.airquality.ui.activities.main.view.MainView
import com.wegrzyn_a.airquality.ui.activities.main.interactor.MeasurementsInteractor
import com.wegrzyn_a.airquality.ui.activities.station_list.IStationResult
import com.wegrzyn_a.airquality.ui.base.mvp.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter(view: MainView, interactor: MeasurementsInteractor) : BasePresenter<MainView, MeasurementsInteractor>(view, interactor) {
    override fun onCreate() {

        view.init()
        view.onStartLoading()
        loadData(getDefaultStation())
    }

    fun selectStation() {
        view.startStationListActivity()
    }

    fun onStationSelected(station: MeasurementStationEntity) {
        loadData(station)
    }

    // TODO
    private fun getDefaultStation() = MeasurementStationEntity(14L, "Działoszyn")

    private fun loadData(station: MeasurementStationEntity) {
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
    }

}