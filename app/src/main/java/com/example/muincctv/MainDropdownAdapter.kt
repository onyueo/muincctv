package com.example.muincctv

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainDropdownAdapter(
    private val context: Context,
    private val dropdownList: ArrayList<MainDropDownModel>
) : RecyclerView.Adapter<MainDropdownAdapter.ViewHolder>() {

    private var onItemClickListener: ((MainDropDownModel) -> Unit)? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.dropdown_item_text)
        val itemImg: TextView = itemView.findViewById(R.id.dropdown_item_img)

        fun bindItems(item: MainDropDownModel) {
            itemName.text = item.device_title
            itemImg.text = item.device_choice
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dropdown, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dropdownList[position]
        holder.bindItems(currentItem)

        Log.d("MainDropdownAdapter", "Binding item at position $position: ${currentItem.device_title}, Choice: ${currentItem.device_choice}")

        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return dropdownList.size
    }

    fun setOnItemClickListener(listener: (MainDropDownModel) -> Unit) {
        onItemClickListener = listener
    }
}