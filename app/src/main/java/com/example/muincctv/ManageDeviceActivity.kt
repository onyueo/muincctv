package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivityManageDeviceBinding

class ManageDeviceActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityManageDeviceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_device)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "기기관리"

    // 리사이클러뷰 설정
        val items: MutableList<ManageDeviceModel> = mutableListOf(
            ManageDeviceModel("거실1", "WON132D234"),
            ManageDeviceModel("작은방", "EKD99DLFDGA"),
            ManageDeviceModel("현관", "WON132C0DKA"),
            ManageDeviceModel("현관", "WON132C0DKA"),
            ManageDeviceModel("현관", "WON132C0DKA"),
            ManageDeviceModel("현관", "WON132C0DKA"),
            ManageDeviceModel("현관", "WON132C0DKA"),
            ManageDeviceModel("현관", "WON132C0DKA"),
            ManageDeviceModel("현관", "WON132C0DKA"),
        )
        recyclerView = findViewById(R.id.manage_device_RV)
        val manageAdapter = ManageDeviceAdapter(items)
        recyclerView.adapter = manageAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


    }
}