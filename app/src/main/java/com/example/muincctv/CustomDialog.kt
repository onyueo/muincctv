package com.example.muincctv

import android.app.Dialog
import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomDialog(
    context: Context,
    private val items: List<MainDropDownModel>,
    private val itemClickListener: (MainDropDownModel) -> Unit
) {
    private val dialog: Dialog = Dialog(context)

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.item_dropdown_list, null)
        dialog.setContentView(view)

        val recyclerView = view.findViewById<RecyclerView>(R.id.dialog_RV)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = DialogRecyclerViewAdapter(context, items, itemClickListener)

        // 다이얼로그 배경을 투명하게 설정
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        // 다이얼로그 크기 조정
        val layoutParams = dialog.window?.attributes
        val displayMetrics = context.resources.displayMetrics
        val width = displayMetrics.widthPixels - 30.dpToPx(context)

        layoutParams?.width = width // 너비 설정 (30dp 마진 적용)
        layoutParams?.height = WindowManager.LayoutParams.WRAP_CONTENT // 높이는 wrap_content
        dialog.window?.attributes = layoutParams
    }

    fun show() {
        dialog.show()
    }
}

fun Int.dpToPx(context: Context): Int {
    return (this * context.resources.displayMetrics.density).toInt()
}


