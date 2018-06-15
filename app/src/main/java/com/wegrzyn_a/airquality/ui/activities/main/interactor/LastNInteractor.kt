package com.wegrzyn_a.airquality.ui.activities.main.interactor

import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementEntity
import com.wegrzyn_a.airquality.ui.utils.DateUtils
import com.wegrzyn_a.airquality.web.RestApi
import io.reactivex.Single

class LastNInteractor(val n: Int) : IMainInteractor {
    override fun getData(): Single<List<MeasurementEntity>> = getLastN(n, 0.01f)

    private fun getLastN(n: Int, min: Float) = RestApi.getMeasurement(92)
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
