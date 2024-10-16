package com.example.muincctv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class LoginFindPwFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_find_pw, container, false)

        // 아이디 찾기 버튼 클릭 리스너 설정
        val findIdButton = view.findViewById<AppCompatButton>(R.id.login_find_pw_BTN)
        findIdButton.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.find_idpw_fragment, LoginFindPwChangeFragment()) // 프래그먼트 교체
            fragmentTransaction.commit() // 트랜잭션 커밋
        }

        return view
    }
}