package com.wegrzyn_a.airquality.ui.activities.main

import com.github.mikephil.charting.data.Entry
import com.wegrzyn_a.airquality.ui.utils.DateUtils
import com.wegrzyn_a.airquality.web.RestApi
import io.reactivex.Single
import java.util.*

class MainInteractor {
    fun getData(): Single<List<Entry>> {
        return RestApi.getMeasurement(92)
                .map {
                    it.values.map {
//                        val millis = DateUtils.parseWebDate(it.date).time
                        val millis = 5f
                        val value = it.value.toFloat()
                        Entry(millis.toFloat(),value)
                    }
                }
    }
}