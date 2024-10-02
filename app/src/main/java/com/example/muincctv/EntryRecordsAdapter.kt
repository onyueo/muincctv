package com.example.muincctv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EntryRecordsAdapter (val List: MutableList<EntryRecordsModel>) : RecyclerView.Adapter<EntryRecordsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntryRecordsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_entry_log, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: EntryRecordsAdapter.ViewHolder, position: Int) {
        val currentItem = List[position]
        holder.bindItems(currentItem)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // 리사이클러 뷰
        private val recordingDate: TextView = itemView.findViewById(R.id.entry_recording_date)
        private val recordingTime: TextView = itemView.findViewById(R.id.entry_recording_time)
        private val recordingPermission: TextView = itemView.findViewById(R.id.entry_recording_permission)

        fun bindItems(item: EntryRecordsModel) {
            recordingDate.text = item.entryDate
            recordingTime.text = item.entryTime
            recordingPermission.text = item.entryPermission
        }
    }

}