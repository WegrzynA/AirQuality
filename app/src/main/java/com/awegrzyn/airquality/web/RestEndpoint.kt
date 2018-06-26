package com.awegrzyn.airquality.web

import com.awegrzyn.airquality.web.measurement.MeasurementResponse
import com.awegrzyn.airquality.web.sensor.SensorResponse
import com.awegrzyn.airquality.web.station.StationResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RestEndpoint {

    @GET("station/findAll")
    fun getStationList(): Single<List<StationResponse>?>

    @GET("station/sensors/{id}")
    fun getSensorList(@Path("id") stationId: Long): Single<List<SensorResponse>?>

    @GET("data/getData/{id}")
    fun getMeasurement(@Path("id")id: Long): Single<MeasurementResponse>
}