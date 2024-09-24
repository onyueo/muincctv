package com.example.muincctv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MainDropdownAdapter(private val context: Context, private val dropdownList: ArrayList<MainDropDownModel>
) : BaseAdapter() {
    override fun getCount(): Int {
        return dropdownList.size
    }

    override fun getItem(p0: Int): Any {
        return dropdownList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    // 선택화면
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val rootView: View = LayoutInflater.from(context).inflate(R.layout.item_dropdown_list, p2, false)

        val itemName: TextView = rootView.findViewById(R.id.dropdown_item_text)
        val itemImg: ImageView = rootView.findViewById(R.id.dropdown_item_img)

        itemName.text = dropdownList[p0].device_title
        itemImg.setImageResource(dropdownList[p0].device_choice)

        // 선택시 아이콘 숨기기
        itemImg.visibility = View.GONE

        return rootView
    }

    // 드롭다운 항목
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.item_dropdown_list, parent, false)

        val itemName: TextView = rootView.findViewById(R.id.dropdown_item_text)
        val itemImg: ImageView = rootView.findViewById(R.id.dropdown_item_img)

        itemName.text = dropdownList[position].device_title
        itemImg.setImageResource(dropdownList[position].device_choice)

        // 드롭다운에서는 보이기
        itemImg.visibility = View.VISIBLE

        return rootView
    }

}