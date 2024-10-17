package com.example.muincctv

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivityEntryRecordsBinding

class EntryRecordsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityEntryRecordsBinding
    private lateinit var entryAdapter: EntryRecordsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_entry_records)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "출입 기록"

        // 툴바 뒤로가기
        var  toolBack = findViewById<AppCompatImageView>(R.id.tool_back)
        toolBack.setOnClickListener {
            onBackPressed()
        }


    // 드롭다운 설정
        var entryDropdownGroup = findViewById<TextView>(R.id.entry_recording_dropdown_group)
        var entryDropdownTime = findViewById<TextView>(R.id.entry_recording_dropdown_time)

        // 데이터 배열
        val devices = listOf("현관", "거실", "거실2", "안방 화장실")
        val devicesList = convertToMainDropDownModel(devices)

        val groups = listOf("오늘", "일주일", "1개월", "3개월", "6개월", "12개월")
        val groupsList = convertToMainDropDownModel(groups)

        entryDropdownGroup.setOnClickListener {
            CustomDialog(this, ArrayList(devicesList)) { selectedItem ->
                entryDropdownGroup.text = selectedItem.device_title
            }.show()
        }

        entryDropdownTime.setOnClickListener {
            CustomDialog(this, ArrayList(groupsList)) { selectedItem ->
                entryDropdownTime.text = selectedItem.device_title
            }.show()
        }



    // 리사이클러뷰 설정 - 출입기록
        val items: MutableList<EntryRecordsModel> = mutableListOf(
            EntryRecordsModel("2024.09.25", "00:23","도어락"),
            EntryRecordsModel("2024.06.20","00:23", "Ai감지"),
            EntryRecordsModel("2024.02.25", "00:23","앱(출입허가자: 김00)"),
            EntryRecordsModel("2024.09.25", "00:23","도어락"),
        )
        recyclerView = findViewById(R.id.entry_recording_RV)
        entryAdapter = EntryRecordsAdapter(items)
        recyclerView.adapter = entryAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        // 출입기록 여부 UI업데이트
        updateUI(items)


    }

    private fun updateUI(items: List<EntryRecordsModel>) {
        // 리사이클러뷰의 데이터 길이에 따라 가시성 설정
        if (items.isEmpty()) {
            binding.noEntryRecordingText.visibility = View.VISIBLE
            binding.entryRecordingRV.visibility = View.GONE
        } else {
            binding.noEntryRecordingText.visibility = View.GONE
            binding.entryRecordingRV.visibility = View.VISIBLE
        }
    }

    fun convertToMainDropDownModel(items: List<String>): List<MainDropDownModel> {
        return items.map { MainDropDownModel(device_title = it, device_choice = "") }
    }

}