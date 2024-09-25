package com.example.muincctv

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainMenuChoiceAdapter(val List: MutableList<MainMenuModel>, private val onItemClick: (MainMenuModel) -> Unit): RecyclerView.Adapter<MainMenuChoiceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainMenuChoiceAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_assist_device_choice_btn, parent, false)

        return ViewHolder(v)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(List[position])
        holder.itemView.setOnClickListener {
            onItemClick(List[position]) // 클릭 이벤트 전달
        }
    }

    override fun getItemCount(): Int {
        return List.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imageView = itemView.findViewById<ImageView>(R.id.assist_device_choice_btn_img)
        private val textView = itemView.findViewById<TextView>(R.id.assist_device_choice_btn_text)

        fun bindItems(item: MainMenuModel) {
            textView.text = item.menu_text
            imageView.setImageResource(item.menu_img)
            itemView.isEnabled = item.is_admin


            if (item.menu_text == "문 열기") {
                imageView.setImageResource(R.drawable.main_door_opend)
                itemView.backgroundTintList = ColorStateList.valueOf(itemView.context.getColor(android.R.color.white))
                textView.setTextColor(itemView.context.getColor(R.color.main_black))
            } else if (item.menu_text == "문 닫기") {
                imageView.setImageResource(R.drawable.main_door_closed)
                itemView.backgroundTintList = ColorStateList.valueOf(itemView.context.getColor(android.R.color.black))
                textView.setTextColor(itemView.context.getColor(R.color.main_white))
            }
        }
    }
}
