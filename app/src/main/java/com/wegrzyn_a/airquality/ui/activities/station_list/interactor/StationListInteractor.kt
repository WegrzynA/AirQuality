package com.wegrzyn_a.airquality.ui.activities.station_list.interactor

import com.wegrzyn_a.airquality.ui.activities.station_list.entity.StationEntity
import com.wegrzyn_a.airquality.web.RestApi
import io.reactivex.Single


class StationListInteractor: IStationListInteractor {
    override fun getData(): Single<List<StationEntity>> =
            RestApi.getStationList()
                    .map {
                        it.map {
                            StationEntity(it.id,it.city?.name ?: "",it.addressStreet ?: "",it.city?.commune?.provinceName ?: "")
                        }
                    }
}