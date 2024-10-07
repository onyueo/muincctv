package com.example.muincctv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView

class AddUserAdapter(val List: MutableList<AddUserModel>) : RecyclerView.Adapter<AddUserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddUserAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_infomation_changer, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: AddUserAdapter.ViewHolder, position: Int) {
        val currentItem = List[position]
        holder.bindItems(currentItem)
    }

    override fun getItemCount(): Int {
        return List.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userName: TextView = itemView.findViewById(R.id.information_text1)
        private val userNumber: TextView = itemView.findViewById(R.id.information_text2)

        private val userBtn: AppCompatButton = itemView.findViewById(R.id.information_btn)
        private val userText2: TextView = itemView.findViewById(R.id.information_title2)

        fun bindItems(item: AddUserModel) {
            userName.text = item.addUserName
            userNumber.text = item.addUserNumber
            userText2.text = "전화번호"
            userBtn.text = "승인"
        }
    }
}