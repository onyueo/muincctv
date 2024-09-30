package com.example.muincctv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecordingListAdapter (val List: MutableList<RecordingListModel>) : RecyclerView.Adapter<RecordingListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecordingListAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recording_list, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecordingListAdapter.ViewHolder, position: Int) {
        val currentItem = List[position]
        holder.bindItems(currentItem)
    }

    override fun getItemCount(): Int {
        return List.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // 드롭다운
//        val rootView: View = LayoutInflater.from(context).inflate(R.layout.item_dropdown_list, parent, false)
//        val itemName: TextView = rootView.findViewById(R.id.dropdown_item_text)

        // 리사이클러 뷰
        private val recordingImg: ImageView = itemView.findViewById(R.id.item_recording_img)
        private val recordingDate: TextView = itemView.findViewById(R.id.item_recording_date)
        private val recordingPermission: TextView = itemView.findViewById(R.id.item_recording_permission)

        fun bindItems(item: RecordingListModel) {
            recordingImg.setImageResource(item.recordingImg) // 이미지 리소스 설정
            recordingDate.text = item.recordingDate // 기간 텍스트 설정
            recordingPermission.text = item.recordingPermission
        }
    }

}
