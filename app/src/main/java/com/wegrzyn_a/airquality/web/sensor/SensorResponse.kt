package com.wegrzyn_a.airquality.web.sensor

class SensorResponse(
        val id: Long,
        val stationId: Long?,
        val param: SensorParamResponse
)