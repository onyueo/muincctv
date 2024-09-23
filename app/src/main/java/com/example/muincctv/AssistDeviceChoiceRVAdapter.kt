package com.example.muincctv

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class AssistDeviceChoiceRVAdapter (val List : MutableList<AssistDeviceModel>) : RecyclerView.Adapter<AssistDeviceChoiceRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AssistDeviceChoiceRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_assist_device_choice_btn, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AssistDeviceChoiceRVAdapter.ViewHolder, position: Int) {
        holder.bindItems(List[position])

        // 클릭시 상태 변경
        holder.itemView.setOnClickListener {
            List[position].isSelected = !List[position].isSelected
            notifyItemChanged(position) // 변경된 아이템만 업데이트
        }
    }

    override fun getItemCount(): Int {
        return List.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: AssistDeviceModel) {
            val rvImg = itemView.findViewById<ImageView>(R.id.assist_device_choice_btn_img)
            val rvText = itemView.findViewById<TextView>(R.id.assist_device_choice_btn_text)
            val rvColor = itemView.findViewById<ConstraintLayout>(R.id.assist_device_choice_btn_container)

            rvImg.setImageResource(item.imgUrl)
            rvText.text = item.title

            if (item.isSelected) { // 아이템 선택시
                rvImg.setImageResource(item.selectedImgUrl)
                rvText.setTextColor(itemView.context.getColor(android.R.color.white))
                rvColor.backgroundTintList = ColorStateList.valueOf(itemView.context.getColor(android.R.color.black))
            } else {
                rvImg.setImageResource(item.imgUrl)
                rvText.setTextColor(itemView.context.getColor(android.R.color.black))
//                rvColor.backgroundTintList = ColorStateList.valueOf(itemView.context.getColor(android.R.color.white))
            }

        }
    }
}