package com.wegrzyn_a.airquality.ui.activities.station_list.view

import android.content.Context
import android.support.v7.widget.LinearLayoutManager


class StationListManager(context: Context): LinearLayoutManager(context) {
    init {
        orientation = VERTICAL
    }
}