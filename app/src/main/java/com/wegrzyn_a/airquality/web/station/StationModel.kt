package com.wegrzyn_a.airquality.web.station

class StationModel(
        val id: Long,
        val stationName: String,
        val gegrLat: String,
        val gegrLon: String,
        val city: CityModel,
        val addressStreet: String
)


