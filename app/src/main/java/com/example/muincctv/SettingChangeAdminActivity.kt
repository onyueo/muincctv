package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivitySettingChangeAdminBinding

class SettingChangeAdminActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivitySettingChangeAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_change_admin)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "관리자 변경"

    // 리사이클러뷰 설정
        val items: MutableList<SettingChangeAdminModel> = mutableListOf(
            SettingChangeAdminModel("김동생", "010-2345-5645"),
            SettingChangeAdminModel("김언니", "010-5522-5645"),
            SettingChangeAdminModel("김오빠", "010-2345-9845"),
            SettingChangeAdminModel("김누나", "010-5555-5645"),
            SettingChangeAdminModel("111", "010-2345-5645"),
            SettingChangeAdminModel("222", "010-2345-9845"),
            SettingChangeAdminModel("333", "010-2345-5645"),
            SettingChangeAdminModel("444", "010-2345-5645"),
            SettingChangeAdminModel("555", "010-2345-5645"),
        )

        recyclerView = findViewById(R.id.setting_change_admin_RV)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val changeAdminAdapter = SettingChangeAdminAdapter(items)
        recyclerView.adapter = changeAdminAdapter


    }
}