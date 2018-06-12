package com.wegrzyn_a.airquality.web

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RestApi {

    lateinit var restEndpoint: RestEndpoint

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(RestConfig.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        restEndpoint = retrofit.create(RestEndpoint::class.java)
    }

    fun getStationList() = restEndpoint.getStationList()

    fun getMeasurement(id: Long) = restEndpoint.getMeasurement(id)

}