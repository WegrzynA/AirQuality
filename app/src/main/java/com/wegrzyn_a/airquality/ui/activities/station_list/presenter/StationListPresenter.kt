package com.wegrzyn_a.airquality.ui.activities.station_list.presenter

import android.util.Log
import com.wegrzyn_a.airquality.ui.activities.station_list.StationParcel
import com.wegrzyn_a.airquality.ui.activities.station_list.entity.StationEntity
import com.wegrzyn_a.airquality.ui.activities.station_list.interactor.IStationListInteractor
import com.wegrzyn_a.airquality.ui.activities.station_list.view.StationListView
import com.wegrzyn_a.airquality.ui.base.mvp.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class StationListPresenter(view: StationListView, interactor: IStationListInteractor) : BasePresenter<StationListView, IStationListInteractor>(view, interactor) {
    override fun onCreate() {

        view.init()
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
                            Log.e("StationListPresenter","error",it)
                            Log.d("StationListPreseter", "error:" + it.message)
                        })
    }

    fun itemClick(item: StationEntity){
        view.closeWithResult(StationParcel(item.id,item.city + item.street))
    }
}