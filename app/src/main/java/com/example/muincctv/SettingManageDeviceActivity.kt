package com.example.muincctv

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivitySettingManageDeviceBinding

class SettingManageDeviceActivity : AppCompatActivity() {

    private lateinit var inUseRecyclerView: RecyclerView
    private lateinit var notInUseRecyclerView: RecyclerView
    lateinit var binding: ActivitySettingManageDeviceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_manage_device)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "이동 보조기기 관리"

    // 리사이클러뷰 설정

        inUseRecyclerView = findViewById(R.id.Setting_manage_device_using_RV)
        notInUseRecyclerView = findViewById(R.id.Setting_manage_device_not_using_RV)

        val items: MutableList<SettingManageDeviceModel> = mutableListOf(
            SettingManageDeviceModel("지팡이", false),
            SettingManageDeviceModel("목발", false),
            SettingManageDeviceModel("워커", true),
            SettingManageDeviceModel("휠체어", false),
            SettingManageDeviceModel("흰지팡이", true),
        )

        val inUseDevices = items.filter { it.isUsing }.toMutableList()
        val notInUseDevices = items.filter { !it.isUsing }.toMutableList()

        inUseRecyclerView.adapter = SettingManageDeviceAdapter(inUseDevices)
        inUseRecyclerView.layoutManager = LinearLayoutManager(this)


        notInUseRecyclerView.adapter = SettingManageDeviceAdapter(notInUseDevices)
        notInUseRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}