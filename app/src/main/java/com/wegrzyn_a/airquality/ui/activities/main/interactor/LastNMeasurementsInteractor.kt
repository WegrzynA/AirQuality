package com.wegrzyn_a.airquality.ui.activities.main.interactor

import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementEntity
import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementStationEntity
import com.wegrzyn_a.airquality.ui.activities.main.interactor.exception.NoSensorException
import com.wegrzyn_a.airquality.ui.utils.DateUtils
import com.wegrzyn_a.airquality.web.RestApi
import io.reactivex.Single

class LastNMeasurementsInteractor(val n: Int) : MeasurementsInteractor {
    override fun getData(station: MeasurementStationEntity): Single<List<MeasurementEntity>> = getLastN(station, n, 0.01f)

    private fun getLastN(station: MeasurementStationEntity, n: Int, min: Float) =
            RestApi
                    .getSensorList(station.id)
                    .map {
                        val sensor = it.find {
                            it.param.paramCode.equals("PM10")
                        }
                        if (sensor != null) sensor else throw NoSensorException()
                    }
                    .flatMap {
                        RestApi.getMeasurement(it.id)
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

}
