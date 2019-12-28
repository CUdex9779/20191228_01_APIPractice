package com.example.a20191228_01_apipractice

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setEvents()
        setValues()

    }


    override fun setEvents() {

//        로그인 버튼이 눌리면 이벤트 처리
//        1. ID입력이 빈칸이라면 "ID를 입력해주세요."토스트 출력
//        2. pw입력이 8글자 미만이라면 "비번이 너무 짧습니다."토스트 출력
//        3. 둘다 괜찮다면 별개로 분기만 준비.

        loginBtn.setOnClickListener {
            val inputId = idEdt.text.toString()
            val inpuPw = pwEdt.text.toString()

            if (inputId ==""){
                Toast.makeText(mContext,"ID를 입력해주세요",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (inpuPw.length <= 7){
                Toast.makeText(mContext,"비번이 너무 짧습니다.",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(mContext,"정상 입력이라 로그인을 시도합니다.",Toast.LENGTH_SHORT).show()

        }

    }

    override fun setValues() {

    }
}
