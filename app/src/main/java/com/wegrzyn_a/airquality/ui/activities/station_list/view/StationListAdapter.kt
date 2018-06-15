package com.wegrzyn_a.airquality.ui.activities.station_list.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wegrzyn_a.airquality.R
import com.wegrzyn_a.airquality.ui.activities.station_list.entity.StationEntity
import kotlinx.android.synthetic.main.item_station.view.*


class StationListAdapter(val clickListener: (StationEntity) -> Unit): RecyclerView.Adapter<StationListAdapter.ViewHolder>() {

    var items: List<StationEntity>? = null

    override fun getItemCount(): Int = items?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)

        item?.let {
            holder.view.setOnClickListener { clickListener.invoke(item) }
            holder.city.text = it.city
            holder.province.text = it.province
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_station, parent, false))
    }

    fun reloadItems(items: List<StationEntity>){
        this.items = items
        notifyDataSetChanged()
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val city = view.city
        val province = view.province
    }
}