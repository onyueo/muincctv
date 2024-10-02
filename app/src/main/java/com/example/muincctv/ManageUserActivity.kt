package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivityManageUserBinding

class ManageUserActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityManageUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_manage_user)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "사용자관리"

    // 리사이클러뷰 설정
        val items: MutableList<ManageUserModel> = mutableListOf(
            ManageUserModel("김무인", "010-2345-3464"),
            ManageUserModel("이무인", "010-3333-4657"),
            ManageUserModel("박무인", "010-9784-6542"),
        )
        recyclerView = findViewById(R.id.manage_user_RV)
        val manageAdapter = ManageUserAdapter(items)
        recyclerView.adapter = manageAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)



    }
}