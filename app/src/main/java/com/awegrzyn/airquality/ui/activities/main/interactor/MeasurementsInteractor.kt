package com.awegrzyn.airquality.ui.activities.main.interactor

import com.awegrzyn.airquality.ui.activities.main.entity.MeasurementEntity
import com.awegrzyn.airquality.ui.activities.main.entity.MeasurementStationEntity
import com.awegrzyn.airquality.ui.base.mvp.BaseInteractor
import io.reactivex.Single

interface MeasurementsInteractor: BaseInteractor {
    fun getData(station: MeasurementStationEntity): Single<List<MeasurementEntity>>
}