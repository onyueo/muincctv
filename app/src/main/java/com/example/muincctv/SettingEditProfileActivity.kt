package com.example.muincctv

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.muincctv.databinding.ActivitySettingEditProfileBinding

class SettingEditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_edit_profile)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "내 정보 수정"

        // 수정하기 버튼 클릭 리스너
        binding.settingEditProfileEditBTN.setOnClickListener {
            togglePasswordField()
        }

    }


    private fun togglePasswordField() {
        val editBtn = binding.settingEditProfileEditBTN.text

        if (editBtn == "수정하기") {
            // 비밀번호 입력창 표시
            binding.settingEditProfilePassword.visibility = View.VISIBLE
            binding.settingEditProfilePasswordInput.visibility = View.VISIBLE
            binding.settingEditProfileEditBTN.text = "저장하기"
        } else if (editBtn == "저장하기") {
            // 저장되었습니다 알람?

            // 화면이동
            val intent = Intent(this, SettingMyInfoActivity::class.java)
            startActivity(intent)

        }
    }




}