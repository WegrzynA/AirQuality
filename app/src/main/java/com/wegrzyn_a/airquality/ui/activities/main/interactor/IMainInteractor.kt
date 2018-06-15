package com.wegrzyn_a.airquality.ui.activities.main.interactor

import com.wegrzyn_a.airquality.ui.activities.main.entity.MeasurementEntity
import com.wegrzyn_a.airquality.ui.base.mvp.BaseInteractor
import io.reactivex.Single

interface IMainInteractor: BaseInteractor {
    fun getData(): Single<List<MeasurementEntity>>
}