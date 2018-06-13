package com.wegrzyn_a.airquality.ui.activities.main.view

import com.wegrzyn_a.airquality.ui.activities.main.model.MeasurementModel
import com.wegrzyn_a.airquality.ui.base.mvp.BaseView

interface MainView: BaseView {
    fun onStartLoading()
    fun onLoadFinished(entries: List<MeasurementModel>)
    fun onLoadError(message: String)
}