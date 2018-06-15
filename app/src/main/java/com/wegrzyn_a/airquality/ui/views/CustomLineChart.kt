package com.wegrzyn_a.airquality.ui.views

import android.content.Context
import android.util.AttributeSet
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineData


class CustomLineChart: LineChart {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    fun setAdapter(adapter: Adapter){
        data = adapter.getData()
        invalidate()
    }

    interface Adapter {
        fun getData(): LineData
    }
}