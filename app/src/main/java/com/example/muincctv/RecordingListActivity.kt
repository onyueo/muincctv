package com.example.muincctv

import android.os.Bundle
import android.view.View
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivityRecordingListBinding

class RecordingListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityRecordingListBinding
    private lateinit var recordingAdapter: RecordingListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recording_list)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // appbar 타이틀 변경
        binding.titleText = "녹화 영상"

        // 툴바 뒤로가기
        var  toolBack = findViewById<AppCompatImageView>(R.id.tool_back)
        toolBack.setOnClickListener {
            onBackPressed()
        }


// 드롭다운 설정
        val recordingDropdownGroup = findViewById<TextView>(R.id.recording_dropdown_group)
        val recordingDropdownTime = findViewById<TextView>(R.id.recording_dropdown_time)

        // 데이터 배열
        val devices = listOf("현관", "거실", "거실2", "안방 화장실")
        val devicesList = convertToMainDropDownModel(devices)

        val groups = listOf("오늘", "일주일", "1개월", "3개월", "6개월", "12개월")
        val groupsList = convertToMainDropDownModel(groups)

        recordingDropdownGroup.setOnClickListener {
            CustomDialog(this, ArrayList(devicesList)) { selectedItem ->
                recordingDropdownGroup.text = selectedItem.device_title
            }.show()
        }

        recordingDropdownTime.setOnClickListener {
            CustomDialog(this, ArrayList(groupsList)) { selectedItem ->
                recordingDropdownTime.text = selectedItem.device_title
            }.show()
        }



    // 리사이클러뷰 설정 - 녹화영상
        val items: MutableList<RecordingListModel> = mutableListOf(
            RecordingListModel(R.drawable.sample_img, "2024.09.25 ~ 2024.09.25", "김무인"),
            RecordingListModel(R.drawable.sample_img, "2024.06.20 ~ 2024.06.22", "이무인"),
            RecordingListModel(R.drawable.sample_img, "2024.02.25 ~ 2024.02.25", "박무인"),
            RecordingListModel(R.drawable.sample_img, "2024.09.25 ~ 2024.09.25", "최무인"),
            RecordingListModel(R.drawable.sample_img, "2024.09.25 ~ 2024.09.25", "강무인"),
        )

        recyclerView = findViewById<RecyclerView>(R.id.recording_RV)
        recordingAdapter = RecordingListAdapter(items)
        recyclerView.adapter = recordingAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        // 녹화영상 여부 UI업데이트
        updateUI(items)

    }

    private fun updateUI(items: List<RecordingListModel>) {
        // 리사이클러뷰의 데이터 길이에 따라 가시성 설정
        if (items.isEmpty()) {
            binding.noRecordingText.visibility = View.VISIBLE
            binding.recordingRV.visibility = View.GONE
        } else {
            binding.noRecordingText.visibility = View.GONE
            binding.recordingRV.visibility = View.VISIBLE
        }
    }

    fun convertToMainDropDownModel(items: List<String>): List<MainDropDownModel> {
        return items.map { MainDropDownModel(device_title = it, device_choice = "") }
    }

}