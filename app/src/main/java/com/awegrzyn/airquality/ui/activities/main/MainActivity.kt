package com.awegrzyn.airquality.ui.activities.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.awegrzyn.airquality.R
import com.awegrzyn.airquality.ui.activities.main.entity.MeasurementEntity
import com.awegrzyn.airquality.ui.activities.main.entity.MeasurementStationEntity
import com.awegrzyn.airquality.ui.activities.main.interactor.LastNMeasurementsInteractor
import com.awegrzyn.airquality.ui.activities.main.presenter.MainPresenter
import com.awegrzyn.airquality.ui.activities.main.view.ChartAdapter
import com.awegrzyn.airquality.ui.activities.main.view.MainView
import com.awegrzyn.airquality.ui.activities.station_list.IStationResult
import com.awegrzyn.airquality.ui.activities.station_list.StationListActivity
import com.awegrzyn.airquality.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<MainPresenter>(), MainView {

    companion object {
        val REQUEST_STATION_LIST = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_STATION_LIST && resultCode == Activity.RESULT_OK) {
            data?.let {
                val station = it.getParcelableExtra<IStationResult>(StationListActivity.RESULT_STATION)
                presenter.onStationSelected(MeasurementStationEntity(station.getStationId(),station.getStationName()))
            }
        }
    }

    override fun onCreatePresenter() = MainPresenter(this, createInteractor())

    override fun init() {
        mainChooseCity.setOnClickListener { presenter.selectStation() }
    }

    override fun onLoadFinished(entries: List<MeasurementEntity>) {
        mainProgress.visibility = View.GONE
        mainContent.visibility = View.VISIBLE

        loadToChart(entries)
    }

    override fun onStartLoading() {
        mainProgress.visibility = View.VISIBLE
        mainContent.visibility = View.GONE
    }

    override fun onLoadError(message: String) {
        mainProgress.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun startStationListActivity() {
        val i = Intent(this, StationListActivity::class.java)
        startActivityForResult(i, REQUEST_STATION_LIST)
    }

    private fun createInteractor() = LastNMeasurementsInteractor(10)

    private fun loadToChart(entries: List<MeasurementEntity>) {
        val adapter = ChartAdapter(entries)
        mainChart.setAdapter(adapter)
    }
}