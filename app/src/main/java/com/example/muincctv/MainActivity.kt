package com.example.muincctv

import android.os.Bundle
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var mainDropdownDevice: Spinner
    private lateinit var mainDropdownGroup: Spinner

    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    // 드롭다운 설정
        mainDropdownDevice = findViewById(R.id.main_dropdown_device)
        mainDropdownGroup = findViewById(R.id.main_dropdown_group)

        // 데이터 배열
        val devices = arrayListOf(
            MainDropDownModel("Device 1", R.drawable.modal_warning_icon),
            MainDropDownModel("Device 2", R.drawable.main_circle_alam),
            MainDropDownModel("Device 3", R.drawable.main_circle_alam)
        )

        val groups = arrayListOf(
            MainDropDownModel("Group A", R.drawable.modal_warning_icon),
            MainDropDownModel("Group B", R.drawable.modal_warning_icon),
            MainDropDownModel("Group C", R.drawable.main_circle_alam)
        )

        // 어댑터 생성 및 스피너에 설정
        val deviceAdapter = MainDropdownAdapter(this, devices)
        mainDropdownDevice.adapter = deviceAdapter

        val groupAdapter = MainDropdownAdapter(this, groups)
        mainDropdownGroup.adapter = groupAdapter


    // 리사이클러뷰 설정 - 메인메뉴 리스트
        val menuItems: MutableList<MainMenuModel> = mutableListOf(
            MainMenuModel("문 열기",R.drawable.main_door_opend, true),
            MainMenuModel("녹화 영상",R.drawable.main_video_play, false),
            MainMenuModel("비상연락", R.drawable.main_sos_call,true),
            MainMenuModel("출입 기록", R.drawable.main_history,true),
            MainMenuModel("사용자 관리", R.drawable.main_manage_user,false),
            MainMenuModel("사용자 추가",R.drawable.main_person_add, false),
            MainMenuModel("기기 관리", R.drawable.main_manage_device,false),
            MainMenuModel("설정", R.drawable.main_setting,true),
            MainMenuModel("녹화 중지",R.drawable.main_record_stop, false),
            MainMenuModel("재부팅", R.drawable.main_reset,false)
        )

        recyclerView = findViewById<RecyclerView>(R.id.main_menu_choice)
        val menuAdapter = MainMenuChoiceAdapter(menuItems)


    }
}