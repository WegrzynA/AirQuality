package com.wegrzyn_a.airquality.ui.activities.station_list.interactor

import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementEntity
import com.wegrzyn_a.airquality.ui.activities.station_list.entity.StationEntity
import com.wegrzyn_a.airquality.ui.base.mvp.BaseInteractor
import io.reactivex.Single


interface IStationListInteractor: BaseInteractor {
    fun getData(): Single<List<StationEntity>>
}