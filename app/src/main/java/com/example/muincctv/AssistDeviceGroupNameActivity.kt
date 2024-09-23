package com.example.muincctv

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AssistDeviceGroupNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_assist_device_group_name)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // 등록버튼 클릭 시 기기ID 입력하는 페이지로 이동
        val goNext = findViewById<AppCompatButton>(R.id.assist_device_name_btn)
        goNext.setOnClickListener {
            val intent = Intent(this, AssistDeviceIdActivity::class.java)
            startActivity(intent)
        }
    }
}