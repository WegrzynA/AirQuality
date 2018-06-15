package com.wegrzyn_a.airquality.ui.activities.station_list

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.wegrzyn_a.airquality.R
import com.wegrzyn_a.airquality.ui.activities.station_list.entity.StationEntity
import com.wegrzyn_a.airquality.ui.activities.station_list.interactor.StationListInteractor
import com.wegrzyn_a.airquality.ui.activities.station_list.presenter.StationListPresenter
import com.wegrzyn_a.airquality.ui.activities.station_list.view.StationListAdapter
import com.wegrzyn_a.airquality.ui.activities.station_list.view.StationListManager
import com.wegrzyn_a.airquality.ui.activities.station_list.view.StationListView
import com.wegrzyn_a.airquality.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_station_list.*


class StationListActivity : BaseActivity<StationListPresenter>(), StationListView {

    companion object {
        val RESULT_STATION = "RESULT_STATION"
    }

    lateinit var adapter: StationListAdapter

    override fun onCreatePresenter() = StationListPresenter(this, createInteractor())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_station_list)
    }

    override fun init() {
        adapter = StationListAdapter(presenter::itemClick)
        stationListRecycler.adapter = adapter
        stationListRecycler.layoutManager = StationListManager(this)
    }

    override fun onStartLoading() {
        stationListRecycler.visibility = View.GONE
        stationListProgress.visibility - View.VISIBLE
    }

    override fun onLoadFinished(entries: List<StationEntity>) {
        stationListRecycler.visibility = View.VISIBLE
        stationListProgress.visibility = View.GONE

        adapter.reloadItems(entries)
    }

    override fun onLoadError(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    override fun closeWithResult(item: StationParcel) {
        intent.putExtra(RESULT_STATION,item)
        setResult(Activity.RESULT_OK,intent)
    }

    private fun createInteractor() = StationListInteractor()
}