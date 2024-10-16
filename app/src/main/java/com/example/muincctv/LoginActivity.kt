package com.example.muincctv

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity(), ConfirmDialogInterface {
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




        // 테스트용
        val jumpBtn = findViewById<TextView>(R.id.jump_jump)
        jumpBtn.setOnClickListener {
            val intent = Intent(this, AssistDeviceChoiceActivity::class.java)
            startActivity(intent)
        }

        // 모달 테스트용
        val kakaoBtn = findViewById<LinearLayout>(R.id.login_kakao_BTN)
        kakaoBtn.setOnClickListener {
            val title = "정말 계정을 삭제하시겠어요?"
            val content = "지금까지의 정보가 모두 사라집니다."

            val dialog = CustomDoubleAlamDialog(this, 1, title)
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "CustomDoubleAlamDialog")
        }

        val naverBtn = findViewById<LinearLayout>(R.id.login_naver_BTN)
        naverBtn.setOnClickListener {
            val content = "아이디 또는 비밀번호가 맞지 않습니다."
            val title = "로그인 실패"

            val dialog = CustomSingleAlamDialog(this, 1, content, title)
            dialog.isCancelable = false
            dialog.show(supportFragmentManager, "CustomDoubleAlamDialog")
        }


    }

    override fun onClickYesButton(id: Int) {
        // 사용자 확인 버튼 클릭 시 수행할 작업
        if (id == 1) {
            // 계정 삭제 로직 추가
            Toast.makeText(this, "계정이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

}

