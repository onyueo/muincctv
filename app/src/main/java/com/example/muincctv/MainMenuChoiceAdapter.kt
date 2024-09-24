package com.example.muincctv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainMenuChoiceAdapter(val List: MutableList<MainMenuModel>): RecyclerView.Adapter<MainMenuChoiceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainMenuChoiceAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_assist_device_choice_btn, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MainMenuChoiceAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return List.size
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: MainMenuModel) {

        }
    }
}