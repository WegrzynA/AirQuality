package com.awegrzyn.airquality.ui.activities.main.view

import com.awegrzyn.airquality.ui.activities.main.entity.MeasurementEntity
import com.awegrzyn.airquality.ui.utils.DateUtils
import com.github.mikephil.charting.data.Entry
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ChartAdapterTest {

    var adapter: ChartAdapter? = null
    var data: List<Triple<Int,Float,String>>? = null

    @Before
    fun setUp() {
        data = createTestSet()

        val l = data!!.map { MeasurementEntity(it.first,it.second, DateUtils.parseTime(it.third)!!) }

        adapter = ChartAdapter(l)
    }

    private fun createTestSet(): List<Triple<Int, Float, String>> {
        return listOf(
                Triple(0, 0F, "00:00"),
                Triple(1, 1F, "01:00"),
                Triple(2, 2F, "02:00"),
                Triple(3, 3F, "03:00"),
                Triple(4, 4F, "04:00")
        )
    }

    @Test
    fun getData() {
        val l: List<Entry> = data!!.map { Entry(it.first.toFloat(),it.second) }

        Pair(l,adapter!!.getData()).iterator().forEach {
            assertEquals(it.first.x,it.second.x,.0f)
            assertEquals(it.first.y,it.second.y)
        }
    }

    @Test
    fun getXLabels() {
        val l = data!!.map { it.third }
        assertEquals(adapter!!.getXLabels(),l)
    }

    fun <A,B> Pair<Iterable<A>,Iterable<B>>.iterator(): Iterator<Pair<A,B>>{
        val firstIt = first.iterator()
        val secondIt = second.iterator()

        return object: Iterator<Pair<A,B>> {
            override fun hasNext(): Boolean {
                return firstIt.hasNext() && secondIt.hasNext()
            }

            override fun next(): Pair<A, B> {
                return Pair(firstIt.next(),secondIt.next())
            }
        }
    }
}