package com.example.muincctv

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainDropdownDevice: TextView
    private lateinit var mainDropdownGroup: TextView

    private lateinit var btnRecyclerView: RecyclerView
    private lateinit var menuAdapter: MainMenuChoiceAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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
            MainDropDownModel("Group B", "admin"),
            MainDropDownModel("Group C", " "),
            MainDropDownModel("Group D", " ")
        )

// 모달 테스트1
        val dataList = arrayOf(
            "항목1", "항목2", "항목3", "항목4", "항목5", "항목6",
        )

        mainDropdownDevice.setOnClickListener {

            val adapter = ArrayAdapter<String>(
                this@MainActivity, android.R.layout.simple_spinner_item, dataList
            )

            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("그룹 선택")

            builder.setAdapter(adapter){ dialogInterface: DialogInterface, i: Int ->
                mainDropdownDevice.text = dataList[i]
            }
            builder.setNegativeButton("취소",null)
            builder.show()
        }

// 모달 테스트 22
        mainDropdownGroup.setOnClickListener {
            CustomDialog(this, groups) { selectedItem ->
                mainDropdownGroup.text = selectedItem.device_title // 선택된 텍스트 설정
            }.show()
        }




    // 리사이클러뷰 설정 - 메인메뉴 리스트
        btnRecyclerView = findViewById<RecyclerView>(R.id.main_menu_choice)
        btnRecyclerView.layoutManager = GridLayoutManager(this, 2)

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
            } else if (menuItem.menu_text == "출입 기록") {
                val intent = Intent(this, EntryRecordsActivity::class.java)
                startActivity(intent)
            } else if (menuItem.menu_text == "사용자 관리") {
                val intent = Intent(this, ManageUserActivity::class.java)
                startActivity(intent)
            } else if (menuItem.menu_text == "기기 관리") {
                val intent = Intent(this, ManageDeviceActivity::class.java)
                startActivity(intent)
            } else if (menuItem.menu_text == "사용자 추가") {
                val intent = Intent(this, AddUserActivity::class.java)
                startActivity(intent)
            } else if (menuItem.menu_text == "설정") {
                val intent = Intent(this, MainSettingActivity::class.java)
                startActivity(intent)
            }
        }

        btnRecyclerView.adapter = menuAdapter

    }


}

