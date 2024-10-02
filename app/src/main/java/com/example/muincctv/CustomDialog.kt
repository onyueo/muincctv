package com.example.muincctv

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomDialog(
    context: Context,
    private val dataList: ArrayList<MainDropDownModel>,
    private val onItemSelected: (MainDropDownModel) -> Unit
) : Dialog(context) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainDropdownAdapter

    init {
        // 레이아웃 설정
        val view = LayoutInflater.from(context).inflate(R.layout.item_dropdown_list, null)
        setContentView(view)

        // 배경을 투명하게 설정
        window?.setBackgroundDrawableResource(android.R.color.transparent)

        // RecyclerView 설정
        recyclerView = view.findViewById(R.id.dialog_RV)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = MainDropdownAdapter(context, dataList)
        recyclerView.adapter = adapter



        // 아이템 클릭 리스너 설정
        adapter.setOnItemClickListener { item ->
            onItemSelected(item)
            dismiss() // 다이얼로그 닫기
        }

        // 다이얼로그 크기 조절
        val params = window?.attributes
        params?.width = context.resources.displayMetrics.widthPixels - 30.dpToPx(context)
        params?.height = WindowManager.LayoutParams.WRAP_CONTENT
        window?.attributes = params

    }

    fun Int.dpToPx(context: Context): Int {
        return (this * context.resources.displayMetrics.density).toInt()
    }
}
