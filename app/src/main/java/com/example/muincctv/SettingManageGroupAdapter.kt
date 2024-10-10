package com.example.muincctv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView

class SettingManageGroupAdapter(val List: MutableList<SettingsGroupManageModel>): RecyclerView.Adapter<SettingManageGroupAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SettingManageGroupAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_infomation_changer, parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: SettingManageGroupAdapter.ViewHolder, position: Int) {
        val currentItem = List[position]
        holder.bindItems(currentItem)
    }

    override fun getItemCount(): Int {
        return List.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val groupNameTitle: TextView = itemView.findViewById(R.id.information_title1)
        private val groupAdminTitle: TextView = itemView.findViewById(R.id.information_title2)
        private val groupDateTitle: TextView = itemView.findViewById(R.id.information_title3)


        private val groupName: TextView = itemView.findViewById(R.id.information_text1)
        private val groupAdmin: TextView = itemView.findViewById(R.id.information_text2)
        private val groupDate: TextView = itemView.findViewById(R.id.information_text3)

        private val mainBtn: AppCompatButton = itemView.findViewById(R.id.information_btn)
        private val deleteBtn: AppCompatButton = itemView.findViewById(R.id.information_delete)


        fun bindItems(item: SettingsGroupManageModel) {
            mainBtn.visibility = View.GONE
            groupDateTitle.visibility = View.VISIBLE
            groupDate.visibility = View.VISIBLE

            groupNameTitle.text = "그룹 이름"
            groupAdminTitle.text = "권한"
            groupDateTitle.text = "가입일"

            groupName.text = item.groupName
            groupAdmin.text = item.groupAdmin
            groupDate.text = item.groupDate
            deleteBtn.text = "그룹 나가기"
        }
    }
}