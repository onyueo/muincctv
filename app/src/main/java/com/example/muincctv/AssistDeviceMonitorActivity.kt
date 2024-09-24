package com.example.muincctv

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AssistDeviceMonitorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_assist_device_monitor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 확인완료 버튼 클릭 시 기기이름 짓는 페이지로 이동
        val goNext = findViewById<AppCompatButton>(R.id.assist_device_monitor_btn)
        goNext.setOnClickListener {
            val intent = Intent(this, AssistDeviceNameActivity::class.java)
            startActivity(intent)
        }
    }
}