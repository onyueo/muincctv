package com.example.muincctv

import android.content.Context
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

    // ViewHolder 클래스
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName: TextView = itemView.findViewById(R.id.dropdown_item_text)
        val itemImg: TextView = itemView.findViewById(R.id.dropdown_item_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dropdown, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dropdownList[position]
        holder.itemName.text = item.device_title
        holder.itemImg.text = item.device_choice

        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return dropdownList.size
    }

    fun setOnItemClickListener(listener: (MainDropDownModel) -> Unit) {
        onItemClickListener = listener
    }
}