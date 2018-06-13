package com.wegrzyn_a.airquality.web.station

class StationResponse(
        val id: Long,
        val stationName: String,
        val gegrLat: String,
        val gegrLon: String,
        val city: StationCityResponse,
        val addressStreet: String
)


