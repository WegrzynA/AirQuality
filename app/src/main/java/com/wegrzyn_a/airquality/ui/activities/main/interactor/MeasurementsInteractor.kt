package com.wegrzyn_a.airquality.ui.activities.main.interactor

import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementEntity
import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementStationEntity
import com.wegrzyn_a.airquality.ui.base.mvp.BaseInteractor
import io.reactivex.Single

interface MeasurementsInteractor: BaseInteractor {
    fun getData(station: MeasurementStationEntity): Single<List<MeasurementEntity>>
}