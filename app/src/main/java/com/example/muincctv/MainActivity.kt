package com.example.muincctv

import android.content.Intent
import android.os.Bundle
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var mainDropdownDevice: TextView
    private lateinit var mainDropdownGroup: TextView

    private lateinit var recyclerView: RecyclerView
    private lateinit var menuAdapter: MainMenuChoiceAdapter

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
            MainDropDownModel("Device 1", "관리자"),
            MainDropDownModel("Device 2", " "),
            MainDropDownModel("Device 3", " ")
        )

        val groups = arrayListOf(
            MainDropDownModel("Group A", " "),
            MainDropDownModel("Group B", "관리자"),
            MainDropDownModel("Group C", " "),
            MainDropDownModel("Group D", " ")
        )

        // 어댑터 생성 및 스피너에 설정
        val deviceAdapter = MainDropdownAdapter(this, devices)
//        mainDropdownDevice.adapter = deviceAdapter

        val groupAdapter = MainDropdownAdapter(this, groups)
//        mainDropdownGroup.adapter = groupAdapter

        // Device TextView 클릭 시 다이얼로그 표시
        mainDropdownDevice.setOnClickListener {
            val customDialog = CustomDialog(this, devices) { selectedItem ->
                mainDropdownDevice.text = selectedItem.device_title // 선택된 텍스트 설정
            }
            customDialog.show()
        }

        // Group TextView 클릭 시 다이얼로그 표시
        mainDropdownGroup.setOnClickListener {
            val customDialog = CustomDialog(this, groups) { selectedItem ->
                mainDropdownGroup.text = selectedItem.device_title // 선택된 텍스트 설정
            }
            customDialog.show()
        }



        // 리사이클러뷰 설정 - 메인메뉴 리스트
        recyclerView = findViewById<RecyclerView>(R.id.main_menu_choice)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val userHasPermission = true // 권한 여부

        val menuItems: MutableList<MainMenuModel> = mutableListOf()

        if (userHasPermission) {
            // 권한이 있는 경우
            menuItems.add(MainMenuModel("문 열기", R.drawable.main_door_opend, true))
            menuItems.add(MainMenuModel("녹화 영상", R.drawable.main_video_play, true))
            menuItems.add(MainMenuModel("비상연락", R.drawable.main_sos_call, true))
            menuItems.add(MainMenuModel("출입 기록", R.drawable.main_history, true))
            menuItems.add(MainMenuModel("사용자 관리", R.drawable.main_manage_user, true))
            menuItems.add(MainMenuModel("사용자 추가", R.drawable.main_person_add, true))
            menuItems.add(MainMenuModel("기기 관리", R.drawable.main_manage_device, true))
            menuItems.add(MainMenuModel("설정", R.drawable.main_setting, true))
            menuItems.add(MainMenuModel("녹화 중지", R.drawable.main_record_stop, true))
            menuItems.add(MainMenuModel("재부팅", R.drawable.main_reset, true))
        } else {
            // 권한이 없는 경우
            menuItems.add(MainMenuModel("문 열기", R.drawable.main_door_opend, true))
            menuItems.add(MainMenuModel("출입 기록", R.drawable.main_history, true))
            menuItems.add(MainMenuModel("비상연락", R.drawable.main_sos_call, true))
            menuItems.add(MainMenuModel("설정", R.drawable.main_setting, true))
        }

        menuAdapter = MainMenuChoiceAdapter(menuItems) { menuItem ->
            // 클릭 이벤트 처리
            if (menuItem.menu_text == "문 열기" || menuItem.menu_text == "문 닫기") {
                menuItem.is_opened = !menuItem.is_opened // 상태 토글
                val newText = if (menuItem.is_opened) "문 닫기" else "문 열기"
                menuItems[0] = menuItem.copy(menu_text = newText)
                menuAdapter.notifyItemChanged(0)

            } else if (menuItem.menu_text == "녹화 영상") {
                val intent = Intent(this, RecordingListActivity::class.java)
                startActivity(intent)
            }
        }

        recyclerView.adapter = menuAdapter


    }
}

