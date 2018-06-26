package com.awegrzyn.airquality.ui.activities.station_list.interactor

import com.awegrzyn.airquality.ui.activities.station_list.entity.StationEntity
import com.awegrzyn.airquality.ui.base.mvp.BaseInteractor
import io.reactivex.Single


interface IStationListInteractor: BaseInteractor {
    fun getData(): Single<List<StationEntity>>
}