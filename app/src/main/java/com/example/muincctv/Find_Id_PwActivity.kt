package com.example.muincctv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class Find_Id_PwActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_find_id_pw)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 기본 프레그먼트 설정
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.find_idpw_fragment, LoginFindIdFragment())
                .commit()
        }

        // 툴바 뒤로가기
        var  toolBack = findViewById<AppCompatImageView>(R.id.tool_back)
        toolBack.setOnClickListener {
            finish()
        }

        settingButtons()


    }


    fun settingButtons() {
        val findIdPwFragment = findViewById<TabLayout>(R.id.find_idpw_tab)

        // 아이디 찾기
        findIdPwFragment.getTabAt(0)?.let { tab ->
            tab.view.setOnClickListener {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.find_idpw_fragment, LoginFindIdFragment())
                fragmentTransaction.commit() // 트랜잭션 완료
            }
        }

        // 비밀번호 찾기
        findIdPwFragment.getTabAt(1)?.let { tab ->
            tab.view.setOnClickListener {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.find_idpw_fragment, LoginFindPwFragment())
                fragmentTransaction.commit() // 트랜잭션 완료
            }
        }


    }

}

