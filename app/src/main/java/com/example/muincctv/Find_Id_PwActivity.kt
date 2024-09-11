package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Find_Id_PwActivity : AppCompatActivity() {
//    private lateinit var binding : ActivityFindIdPwBinding
//    private val tabTextList = listOf("아이디 찾기", "비밀번호 찾기")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_find_id_pw)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 탭바 페이지 이동
//        binding = ActivityFindIdPwBinding.inflate(layoutInflater)
//        binding.viewPager.adapter = Find
//



    }
}






//        // 뒤로가기 설정.. -> 재설정 필요?
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)
//
//        val backButton = findViewById<AppCompatImageView>(R.id.tool_back)
//        backButton.setOnClickListener {
//            onBackPressed()
//        }
//    }
//
//    override fun onBackPressed() {
//        super.onBackPressed()
//    }
//}