package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivityAddUserBinding

class AddUserActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityAddUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_user)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "사용자 추가"

    // 리사이클러뷰 설정
        val items: MutableList<AddUserModel> = mutableListOf(
            AddUserModel("김동생", "010-2345-5645"),
            AddUserModel("김언니", "010-5522-5645"),
            AddUserModel("김오빠", "010-2345-9845"),
            AddUserModel("김누나", "010-5555-5645"),
            AddUserModel("111", "010-2345-5645"),
            AddUserModel("222", "010-2345-9845"),
            AddUserModel("333", "010-2345-5645"),
            AddUserModel("444", "010-2345-5645"),
            AddUserModel("555", "010-2345-5645"),
        )

        recyclerView = findViewById(R.id.add_user_RV)
        val userAdapter = AddUserAdapter(items)
        recyclerView.adapter = userAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}