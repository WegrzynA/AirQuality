package com.awegrzyn.airquality.ui.activities.main.view

import com.github.mikephil.charting.data.Entry
import com.awegrzyn.airquality.ui.activities.main.entity.MeasurementEntity
import com.awegrzyn.airquality.ui.utils.DateUtils
import com.awegrzyn.airquality.ui.views.CustomLineChart


class ChartAdapter(val list: List<MeasurementEntity>) : CustomLineChart.Adapter {
    override fun getData(): List<Entry> = list.map { Entry(it.index.toFloat(), it.value) }
    override fun getXLabels(): List<String> = list.map { DateUtils.formatTime(it.label) }
}