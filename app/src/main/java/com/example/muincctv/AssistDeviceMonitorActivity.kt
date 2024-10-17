package com.example.muincctv

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
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

        // 툴바 뒤로가기
        var  toolBack = findViewById<AppCompatImageView>(R.id.tool_back)
        toolBack.setOnClickListener {
            onBackPressed()
        }

        // 기기화면 이상 버튼 클릭 시 안내페이지로 이동
        val goCheckDeviceInfo = findViewById<TextView>(R.id.assist_device_monitor_check_BTN)
        goCheckDeviceInfo.setOnClickListener {
            val intent = Intent(this, DeviceScreenCheckActivity::class.java)
            startActivity(intent)
        }

        // 확인완료 버튼 클릭 시 기기이름 짓는 페이지로 이동
        val goNext = findViewById<AppCompatButton>(R.id.assist_device_monitor_btn)
        goNext.setOnClickListener {
            val intent = Intent(this, AssistDeviceNameActivity::class.java)
            startActivity(intent)
        }
    }
}