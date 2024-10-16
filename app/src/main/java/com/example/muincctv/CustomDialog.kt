package com.example.muincctv

import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class CustomDialog(
    context: Context,
    private val dataList: ArrayList<MainDropDownModel>,
    private val onItemSelected: (MainDropDownModel) -> Unit
) : Dialog(context) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dropdownAdapter: MainDropdownAdapter

    init {
        // 레이아웃 설정
        val view = LayoutInflater.from(context).inflate(R.layout.item_dropdown_list, null)
        setContentView(view)

        // title 변경
        var dialogTitle = view.findViewById<TextView>(R.id.dialog_title)
        dialogTitle.text = "기기 선택"

        var closeButton = view.findViewById<ImageView>(R.id.dialog_close_icon)
        closeButton.setOnClickListener {
            dismiss()
        }

//        for (item in dataList) {
//            Log.d("CustomDialog", "item: device_title: ${item.device_title}, device_choice: ${item.device_choice}")
//        }

        // RecyclerView 설정
        recyclerView = view.findViewById(R.id.dialog_RV)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // 배경을 투명하게 설정
        window?.setBackgroundDrawableResource(android.R.color.transparent)

        // dropdownAdapter 초기화
        dropdownAdapter = MainDropdownAdapter(context, dataList)
        recyclerView.adapter = dropdownAdapter

        // 아이템 클릭 리스너 설정
        dropdownAdapter.setOnItemClickListener { item ->
            onItemSelected(item)
            dismiss() // 다이얼로그 닫기
        }

        val params = window?.attributes
        params?.width = context.resources.displayMetrics.widthPixels - 30.dpToPx(context)
        params?.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes = params

    }

    fun Int.dpToPx(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }
}
