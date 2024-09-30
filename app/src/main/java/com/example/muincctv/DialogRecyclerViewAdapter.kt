package com.example.muincctv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DialogRecyclerViewAdapter(
    private val context: Context,
    private val itemList: List<MainDropDownModel>,
    private val itemClickListener: (MainDropDownModel) -> Unit
) : RecyclerView.Adapter<DialogRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.dropdown_item_text)

        fun bind(item: MainDropDownModel) {
            itemName.text = item.device_title
            itemView.setOnClickListener {
                itemClickListener(item) // 클릭 시 리스너 호출
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dropdown, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
