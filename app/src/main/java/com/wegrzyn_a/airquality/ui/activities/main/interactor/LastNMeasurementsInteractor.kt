package com.wegrzyn_a.airquality.ui.activities.main.interactor

import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementEntity
import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementStationEntity
import com.wegrzyn_a.airquality.ui.utils.DateUtils
import com.wegrzyn_a.airquality.web.RestApi
import io.reactivex.Single

class LastNMeasurementsInteractor(val n: Int) : MeasurementsInteractor {
    override fun getData(station: MeasurementStationEntity): Single<List<MeasurementEntity>> = getLastN(n, 0.01f)

    private fun getLastN(sensorId: Long, n: Int, min: Float) = RestApi.getMeasurement(sensorId)
            .map {
                it.values
                        .reversed()
                        .filterIndexed { index, measurementDataResponse -> index < n }
                        .filter { it.value > min }
                        .mapIndexed { index, dataModel ->
                            val value = dataModel.value.toFloat()
                            val label = dataModel.date
                            MeasurementEntity(index, value, DateUtils.parseWebDate(label))
                        }
            }
}
