package com.example.muincctv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmergencyContactBottomsheetAdapter(val List: MutableList<EmergencyContactModel>): RecyclerView.Adapter<EmergencyContactBottomsheetAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmergencyContactBottomsheetAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_emergency_contact, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(
        holder: EmergencyContactBottomsheetAdapter.ViewHolder,
        position: Int
    ) {
        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val contactName = itemView.findViewById<TextView>(R.id.emergency_contact_item_name)
        private val contactNumber = itemView.findViewById<TextView>(R.id.emergency_contact_item_number)

        fun bindItems(item: EmergencyContactModel) {
            contactName.text = item.name
            contactNumber.text = item.phone
        }
    }
}