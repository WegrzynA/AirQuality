package com.wegrzyn_a.airquality.ui.utils

import android.annotation.SuppressLint
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    val HH_MM: DateFormat? = DateFormat.getTimeInstance(DateFormat.SHORT)

    @SuppressLint("SimpleDateFormat")
    val WEB_FORMAT = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    fun parseWebDate(date: String): Date{
        val format = WEB_FORMAT
        return format.parse(date)
    }

    fun formatTime(date: Date): String = HH_MM?.format(date) ?: "HH:mm"
}