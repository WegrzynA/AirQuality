package com.awegrzyn.airquality.ui.activities.station_list.view

import com.awegrzyn.airquality.ui.activities.station_list.StationParcel
import com.awegrzyn.airquality.ui.activities.station_list.entity.StationEntity
import com.awegrzyn.airquality.ui.base.mvp.BaseView


interface StationListView: BaseView {
    fun onStartLoading()
    fun onLoadFinished(entries: List<StationEntity>)
    fun onLoadError(message: String)
    fun init()
    fun closeWithResult(item: StationParcel)
}