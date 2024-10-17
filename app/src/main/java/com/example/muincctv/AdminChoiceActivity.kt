package com.example.muincctv

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AdminChoiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_choice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 버튼 클릭 시 관리자 설정 화면으로 이동
        val adminOwnerBtn = findViewById<LinearLayout>(R.id.admin_choice_owner_BTN)
        adminOwnerBtn.setOnClickListener {
            val intent = Intent(this, AssistDeviceChoiceActivity::class.java)
            startActivity(intent)
        }

        // 버튼 클릭 시 게스트 설정 화면으로 이동 - 연결전
        val adminGuestBtn = findViewById<LinearLayout>(R.id.admin_choice_guest_BTN)
        adminGuestBtn.setOnClickListener {
            val intent = Intent(this, AssistDeviceGroupNameActivity::class.java)
            startActivity(intent)
        }


    }
}