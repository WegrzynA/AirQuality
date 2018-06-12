package com.wegrzyn_a.airquality.ui.activities.main

import com.github.mikephil.charting.data.Entry

interface MainView {
    fun loadData(entries: List<Entry>)
}