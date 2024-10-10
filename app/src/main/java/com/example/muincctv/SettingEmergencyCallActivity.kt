package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivitySettingEmergencyCallBinding

class SettingEmergencyCallActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var binding: ActivitySettingEmergencyCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_emergency_call)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "비상연락처 관리"

    // 리사이클러뷰 설정
        val items: MutableList<SettingChangeAdminModel> = mutableListOf(
            SettingChangeAdminModel("김11", "010-2345-2342"),
            SettingChangeAdminModel("김22", "010-2345-2342"),
            SettingChangeAdminModel("김33", "010-2345-2342"),
        )

        recyclerView = findViewById(R.id.Setting_emergency_call_RV)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SettingEmergencyCallAdapter(items)

        // 연락처 등록 버튼 비활성화 로직
        checkIfButtonShouldBeDisabled(items.size)


    }

    private fun checkIfButtonShouldBeDisabled(itemCount: Int) {
        if (itemCount >= 3) {
            binding.manageDeviceBTN.isEnabled = false
        } else {
            binding.manageDeviceBTN.isEnabled = true
        }
    }


}