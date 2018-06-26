package com.awegrzyn.airquality.ui.activities.main.view

import com.awegrzyn.airquality.ui.activities.main.entity.MeasurementEntity
import com.awegrzyn.airquality.ui.base.mvp.BaseView

interface MainView: BaseView {
    fun onStartLoading()
    fun onLoadFinished(entries: List<MeasurementEntity>)
    fun onLoadError(message: String)
    fun init()
    fun startStationListActivity()
}