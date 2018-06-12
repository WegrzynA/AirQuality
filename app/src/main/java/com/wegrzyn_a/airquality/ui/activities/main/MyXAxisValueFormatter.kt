package com.wegrzyn_a.airquality.ui.activities.main

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import java.lang.Long
import java.text.SimpleDateFormat
import java.util.*

class MyXAxisValueFormatter: IAxisValueFormatter {
    override fun getFormattedValue(value: Float, axis: AxisBase?): String {
        try {
            val sdf = SimpleDateFormat("dd MMM")

            return sdf.format(Date(Long.parseLong(value.toString())))
        } catch (e: Exception) {
            return value.toString()
        }

    }
}