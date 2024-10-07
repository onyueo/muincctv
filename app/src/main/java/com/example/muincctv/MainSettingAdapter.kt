package com.example.muincctv

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainSettingAdapter(private val items: List<MainSettingModel>, private val context: Context) : RecyclerView.Adapter<MainSettingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainSettingAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_single_text_btn, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainSettingAdapter.ViewHolder, position: Int) {
        val currentItem = items[position]
        holder.bindItems(currentItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.single_text_title)

        fun bindItems(item: MainSettingModel) {
            title.text = item.title
            itemView.setOnClickListener {
                val intent = Intent(context, item.destination)
                context.startActivity(intent)
            }
        }
    }

}