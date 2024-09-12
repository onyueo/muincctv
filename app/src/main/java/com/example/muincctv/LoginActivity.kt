package com.example.muincctv

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 버튼 클리 시 아이디/비번찾기 화면으로 이동
        val findIDPWBtn = findViewById<TextView>(R.id.loading_find_id)
        findIDPWBtn.setOnClickListener {
            val intent = Intent(this, Find_Id_PwActivity::class.java)
            startActivity(intent)
        }

        // 버튼 클리 시 회원가입 화면으로 이동
        val goSignUpBtn = findViewById<AppCompatButton>(R.id.go_signup_btn)
        goSignUpBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // 로그인 버튼 클리 시 메인 화면으로 이동
        val loadingLoginBtn = findViewById<AppCompatButton>(R.id.loading_login_btn)
        loadingLoginBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}

