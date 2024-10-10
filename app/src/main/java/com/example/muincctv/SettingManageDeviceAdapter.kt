package com.example.muincctv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SettingManageDeviceAdapter(val List: MutableList<SettingManageDeviceModel>): RecyclerView.Adapter<SettingManageDeviceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SettingManageDeviceAdapter.ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.item_single_text_btn, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: SettingManageDeviceAdapter.ViewHolder, position: Int) {
        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val deviceNameTextView: TextView = itemView.findViewById(R.id.single_text_title)

        fun bindItems(item: SettingManageDeviceModel) {
            deviceNameTextView.text = item.deviceName
        }

    }
}