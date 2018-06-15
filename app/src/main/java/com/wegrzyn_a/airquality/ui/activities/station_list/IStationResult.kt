package com.wegrzyn_a.airquality.ui.activities.station_list

import android.os.Parcelable


interface IStationResult : Parcelable {
    fun getStationId(): Long
    fun getStationName(): String
}