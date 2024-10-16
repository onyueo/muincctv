package com.example.muincctv

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.muincctv.databinding.ItemErrorDoubleModalMsgBinding

interface ConfirmDialogInterface {
    fun onClickYesButton(id: Int)
}

class CustomDoubleAlamDialog(
    private val confirmDialogInterface: ConfirmDialogInterface,
    title: String, content: String?, id: Int
) : DialogFragment() {

    // 뷰 바인딩 정의
    private var _binding: ItemErrorDoubleModalMsgBinding? = null
    private val binding get() = _binding!!

    private var title: String? = null
    private var content: String? = null
    private var id: Int? = null

    init {
        this.title = title
        this.content = content
        this.id = id
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ItemErrorDoubleModalMsgBinding.inflate(inflater, container, false)
        val view = binding.root

        // 레이아웃 배경을 투명하게 해줌
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // 제목
        binding.doubleAlamModalTitle.text = title
        // 내용
        if (content == null) {
            binding.doubleAlamModalMsg.visibility = View.GONE
        } else {
            binding.doubleAlamModalMsg.text = content
        }

        // 취소 버튼 클릭
        binding.doubleAlamModalBTNLeft.setOnClickListener {
            dismiss()
        }

        // 확인 버튼 클릭
        binding.doubleAlamModalBTNRight.setOnClickListener {
            this.confirmDialogInterface?.onClickYesButton(id!!)
            dismiss()
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        // 다이얼로그의 크기 설정
        dialog?.let {
            val width = (resources.displayMetrics.widthPixels * 0.8).toInt()
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            it.window?.setLayout(width, height)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}