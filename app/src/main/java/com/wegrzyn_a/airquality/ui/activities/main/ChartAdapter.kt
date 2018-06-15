package com.wegrzyn_a.airquality.ui.activities.main

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.wegrzyn_a.airquality.R
import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementEntity
import com.wegrzyn_a.airquality.ui.views.CustomLineChart


class ChartAdapter(val list: List<MeasurementEntity>) : CustomLineChart.Adapter {
    override fun getData(): LineData {
        val dataSet = LineDataSet(list.map { Entry(it.index.toFloat(), it.value) }, "Label")

        dataSet.setColor(R.color.colorPrimary)
        dataSet.setValueTextColor(R.color.colorAccent)

        return LineData(dataSet)
    }
}