package com.wegrzyn_a.airquality.ui.activities.main.interactor

import com.wegrzyn_a.airquality.ui.activities.main.model.MeasurementModel
import com.wegrzyn_a.airquality.web.RestApi
import io.reactivex.Single

class MainInteractor: IMainInteractor {
    override fun getData(): Single<List<MeasurementModel>> {
        return RestApi.getMeasurement(92)
                .map {
                    it.values.mapIndexed { index, dataModel ->
//                        val millis = DateUtils.parseWebDate(it.date).time
//                        val millis = 5f
                        val value = dataModel.value.toFloat()
                        val label = dataModel.date
//                        Entry(millis.toFloat(),value)
                        MeasurementModel(index,value,label)
                    }
                }
    }
}