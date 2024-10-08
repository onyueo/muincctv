package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.muincctv.databinding.ActivitySettingEditAdBinding

class SettingEditAdActivity : AppCompatActivity() {

    lateinit var binding: ActivitySettingEditAdBinding

    // 각 스위치 상태를 저장할 변수들
    private var isAdTotalEnabled = false
    private var isAppPushEnabled = false
    private var isEmailEnabled = false
    private var isSNSEnabled = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_edit_ad)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "광고성 정보 수신 설정"

    // 토글 이벤트
        // 스위치 초기 상태 설정
        binding.settingEditAdTotalToggle.isChecked = isAdTotalEnabled
        binding.settingEditAdAppToggle.isChecked = isAppPushEnabled
        binding.settingEditAdEmailToggle.isChecked = isEmailEnabled
        binding.settingEditAdSnsToggle.isChecked = isSNSEnabled

        setupSwitchListeners()

    }

    private fun setupSwitchListeners() {
        // 알림 전체 스위치
        binding.settingEditAdTotalToggle.setOnCheckedChangeListener { _, isChecked ->
            isAdTotalEnabled = isChecked
            // 필요시 추가 로직 구현
        }

        // 앱 푸시 스위치
        binding.settingEditAdAppToggle.setOnCheckedChangeListener { _, isChecked ->
            isAppPushEnabled = isChecked
            // 필요시 추가 로직 구현
        }

        // 이메일 스위치
        binding.settingEditAdEmailToggle.setOnCheckedChangeListener { _, isChecked ->
            isEmailEnabled = isChecked
            // 필요시 추가 로직 구현
        }

        // SNS 스위치
        binding.settingEditAdSnsToggle.setOnCheckedChangeListener { _, isChecked ->
            isSNSEnabled = isChecked
            // 필요시 추가 로직 구현
        }
    }



}