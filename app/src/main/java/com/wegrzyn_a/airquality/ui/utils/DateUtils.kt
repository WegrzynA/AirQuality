package com.wegrzyn_a.airquality.ui.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun parseWebDate(date: String): Date{
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return format.parse(date)
    }
}