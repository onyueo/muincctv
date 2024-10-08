package com.example.muincctv

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.muincctv.databinding.ActivitySettingMyInfoBinding

class SettingMyInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivitySettingMyInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_my_info)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "설정"

        // 버튼 클리 시 내 정보 수정 화면으로 이동
        val goEditProfileBtn = findViewById<TextView>(R.id.setting_edit_profile)
        goEditProfileBtn.setOnClickListener {
            val intent = Intent(this, SettingEditProfileActivity::class.java)
            startActivity(intent)
        }

        // 버튼 클리 시 광고성 정보 수신 설정 화면으로 이동
        val goEditAdBtn = findViewById<TextView>(R.id.setting_edit_ad)
        goEditAdBtn.setOnClickListener {
            val intent = Intent(this, SettingEditAdActivity::class.java)
            startActivity(intent)
        }

        // 버튼 클리 시 비밀번호 변경 화면으로 이동
        val goEditPasswordBtn = findViewById<TextView>(R.id.setting_edit_password)
        goEditPasswordBtn.setOnClickListener {
            val intent = Intent(this, SettingEditPasswordActivity::class.java)
            startActivity(intent)
        }

    }
}