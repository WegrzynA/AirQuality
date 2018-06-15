package com.wegrzyn_a.airquality.ui.activities.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.wegrzyn_a.airquality.R
import com.wegrzyn_a.airquality.ui.activities.main.interactor.LastNInteractor
import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementEntity
import com.wegrzyn_a.airquality.ui.activities.main.presenter.MainPresenter
import com.wegrzyn_a.airquality.ui.activities.main.view.MainView
import com.wegrzyn_a.airquality.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity: BaseActivity(), MainView {
    override fun onCreatePresenter() = MainPresenter(this, createInteractor())

    private fun createInteractor() = LastNInteractor(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onLoadFinished(entries: List<MeasurementEntity>) {
        mainProgress.visibility = View.GONE
        mainContent.visibility = View.VISIBLE

        loadToChart(entries)
    }

    private fun loadToChart(entries: List<MeasurementEntity>) {
        val adapter = ChartAdapter(entries)
        mainChart.setAdapter(adapter)
    }

    override fun onStartLoading() {
        mainProgress.visibility = View.VISIBLE
        mainContent.visibility = View.GONE
    }

    override fun onLoadError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

}