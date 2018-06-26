package com.awegrzyn.airquality.ui.activities.station_list

import kotlinx.android.parcel.Parcelize

@Parcelize
class StationParcel(val id: Long, val name: String) : IStationResult {

    override fun getStationId() = id

    override fun getStationName() = name

}