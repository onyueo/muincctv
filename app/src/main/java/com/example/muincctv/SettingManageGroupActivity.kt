package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivitySettingManageGroupBinding

class SettingManageGroupActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivitySettingManageGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_manage_group)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "그룹 관리"

    // 리사이클러뷰 설정
        val items: MutableList<SettingsGroupManageModel> = mutableListOf(
            SettingsGroupManageModel("김12집", "일반", "2024-09-22"),
            SettingsGroupManageModel("kkk집", "일반", "2024-09-55"),
            SettingsGroupManageModel("ddd집", "일반", "2024-08-22"),
            SettingsGroupManageModel("ddd집", "일반", "2024-08-22"),
        )

        recyclerView = findViewById(R.id.setting_manage_group_RV)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val manageGroupAdapter = SettingManageGroupAdapter(items)
        recyclerView.adapter = manageGroupAdapter

    }
}