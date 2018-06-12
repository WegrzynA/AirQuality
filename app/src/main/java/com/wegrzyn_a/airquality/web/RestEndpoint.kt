package com.wegrzyn_a.airquality.web

import com.wegrzyn_a.airquality.web.measurement.MeasurementModel
import com.wegrzyn_a.airquality.web.station.StationModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RestEndpoint {

    @GET("station/findAll")
    fun getStationList(): Single<List<StationModel>>

    @GET("data/getData/{id}")
    fun getMeasurement(@Path("id")id: Long): Single<MeasurementModel>
}