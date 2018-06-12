package com.wegrzyn_a.airquality.ui.activities.main

import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.wegrzyn_a.airquality.R
import com.wegrzyn_a.airquality.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.components.XAxis




class MainActivity: BaseActivity(), MainView {
    override fun onCreatePresenter() = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun loadData(entries: List<Entry>) {
        val dataSet = LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(R.color.colorPrimary)
        dataSet.setValueTextColor(R.color.colorAccent)

        val lineData = LineData(dataSet)
        mainChart.setData(lineData)
        mainChart.invalidate()
    }

    fun configureChart(mChart: LineChart){
        val xAxis = mChart.getXAxis()
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)
        xAxis.setValueFormatter(MyXAxisValueFormatter())
//        xAxis.setLabelsToSkip(0)
    }
}