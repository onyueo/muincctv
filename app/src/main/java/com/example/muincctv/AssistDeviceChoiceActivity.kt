package com.example.muincctv

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AssistDeviceChoiceActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val selectedItems = mutableSetOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_assist_device_choice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 리사이클러뷰 설정 - 이동보조기기 선택
        val items: MutableList<AssistDeviceModel> = mutableListOf(
            AssistDeviceModel(R.drawable.assist_device_cane_black, R.drawable.assist_device_cane_white, "지팡이"),
            AssistDeviceModel(R.drawable.assist_device_crutch_black, R.drawable.assist_device_crutch_white, "목발"),
            AssistDeviceModel(R.drawable.assist_device_wheelchair_black, R.drawable.assist_device_wheelchair_white, "휠체어"),
            AssistDeviceModel(R.drawable.assist_device_walker_black, R.drawable.assist_device_walker_white, "워커"),
            AssistDeviceModel(R.drawable.assist_device_walkingcart_black, R.drawable.assist_device_walkingcart_white, "보행차"),
            AssistDeviceModel(R.drawable.assist_device_x_black, R.drawable.assist_device_x_white, "선택안함")
        )

        recyclerView = findViewById<RecyclerView>(R.id.assist_device_choice_RV)
        val assistAdapter = AssistDeviceChoiceRVAdapter(items)
        recyclerView.adapter = assistAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)



        // 확인버튼 클릭 시 그룹이름 정하는 페이지로 이동
        val goNext = findViewById<AppCompatButton>(R.id.assist_device_choice_btn)
        goNext.setOnClickListener {
            val intent = Intent(this, AssistDeviceGroupNameActivity::class.java)
            startActivity(intent)
        }
    }
}