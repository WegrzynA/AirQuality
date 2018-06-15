package com.wegrzyn_a.airquality.ui.views

import android.content.Context
import android.util.AttributeSet
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet


class CustomLineChart: LineChart {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    private var adapter: Adapter? = null

    fun setAdapter(adapter: Adapter){
        this.adapter = adapter
        reload()
    }

    private fun reload(){
        adapter?.let {
            setPlotData(it.getData())
            setXLabels(it.getXLabels())
            invalidate()
        }
    }

    private fun setPlotData(entries: List<Entry>) {
        val dataSet = LineDataSet(entries, "Label")
        data = LineData(dataSet)
    }

    private fun setXLabels(labels: List<String>) {
        val xAxisLabels = labels

        val xAxis = getXAxis()
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.setDrawGridLines(false)
        xAxis.setValueFormatter({ value, axis -> xAxisLabels.get(value.toInt()) })
    }


    interface Adapter {
        fun getData(): List<Entry>
        fun getXLabels(): List<String>
    }
}