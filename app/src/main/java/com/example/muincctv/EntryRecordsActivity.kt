package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.muincctv.databinding.ActivityEntryRecordsBinding

class EntryRecordsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ActivityEntryRecordsBinding

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


    // 리사이클러뷰 설정 - 출입기록
        val items: MutableList<EntryRecordsModel> = mutableListOf(
            EntryRecordsModel("2024.09.25", "00:23","도어락"),
            EntryRecordsModel("2024.06.20","00:23", "Ai감지"),
            EntryRecordsModel("2024.02.25", "00:23","앱(출입허가자: 김00)"),
            EntryRecordsModel("2024.09.25", "00:23","도어락"),
        )
        recyclerView = findViewById(R.id.entry_recording_RV)
        val entryAdapter = EntryRecordsAdapter(items)
        recyclerView.adapter = entryAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}