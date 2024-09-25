package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivityRecordingListBinding

class RecordingListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private lateinit var binding: ActivityRecordingListBinding

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
        binding.titleText = "직원 관리"

        // 리사이클러뷰 설정 - 녹화영상
        val items: MutableList<RecordingListModel> = mutableListOf(
            RecordingListModel(R.drawable.sample_img, "2024.09.25 ~ 2024.09.25", "김무인"),
            RecordingListModel(R.drawable.sample_img, "2024.06.20 ~ 2024.06.22", "이무인"),
            RecordingListModel(R.drawable.sample_img, "2024.02.25 ~ 2024.02.25", "박무인"),
            RecordingListModel(R.drawable.sample_img, "2024.09.25 ~ 2024.09.25", "최무인"),
            RecordingListModel(R.drawable.sample_img, "2024.09.25 ~ 2024.09.25", "강무인"),
        )

        recyclerView = findViewById<RecyclerView>(R.id.recording_RV)
        val recordingAdapter = RecordingListAdapter(items)
        recyclerView.adapter = recordingAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)



    }
}