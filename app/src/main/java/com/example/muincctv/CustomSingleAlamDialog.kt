package com.example.muincctv

import androidx.fragment.app.DialogFragment
import com.example.muincctv.databinding.ItemErrorSingleModalMsgBinding


class CustomSingleAlamDialog(
    private val confirmDialogInterface: ConfirmDialogInterface,
    id: Int, content: String?, title: String? = null
) : DialogFragment() {

    // 뷰 바인딩 정의
    private var _binding: ItemErrorSingleModalMsgBinding? = null
    private val binding get() = _binding!!

    private var title: String? = null
    private var content: String? = null
    private var id: Int? = null

    init {
        this.title = title
        this.content = content
        this.id = id
    }


}