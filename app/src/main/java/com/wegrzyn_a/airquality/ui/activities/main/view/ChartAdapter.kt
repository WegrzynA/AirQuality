package com.wegrzyn_a.airquality.ui.activities.main.view

import com.github.mikephil.charting.data.Entry
import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementEntity
import com.wegrzyn_a.airquality.ui.utils.DateUtils
import com.wegrzyn_a.airquality.ui.views.CustomLineChart


class ChartAdapter(val list: List<MeasurementEntity>) : CustomLineChart.Adapter {
    override fun getData(): List<Entry> = list.map { Entry(it.index.toFloat(), it.value) }
    override fun getXLabels(): List<String> = list.map { DateUtils.formatTime(it.label) }
}