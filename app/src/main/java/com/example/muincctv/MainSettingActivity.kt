package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivityMainSettingBinding

class MainSettingActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityMainSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_setting)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "설정"

    // 리사이클러뷰 설정
        val settings = listOf(
            MainSettingModel("내 정보", SettingMyInfoActivity::class.java),
            MainSettingModel("그룹 관리", SettingManageGroupActivity::class.java),
            MainSettingModel("관리자 변경", SettingChangeAdminActivity::class.java),

            // ~연결 전~
            MainSettingModel("이동 보조기기 관리", SettingMyInfoActivity::class.java),
            MainSettingModel("비상연락처 관리", SettingMyInfoActivity::class.java),
            MainSettingModel("MU:N 약관 보기", SettingMyInfoActivity::class.java),
            MainSettingModel("고객센터 연결", SettingMyInfoActivity::class.java)
        )

        recyclerView = binding.mainSettingRV
        recyclerView.layoutManager = LinearLayoutManager(this)

        val settingAdapter = MainSettingAdapter(settings, this)
        recyclerView.adapter = settingAdapter


    }
}