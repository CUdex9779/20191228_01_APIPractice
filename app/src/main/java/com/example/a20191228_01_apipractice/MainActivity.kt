package com.example.a20191228_01_apipractice

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setValues()
        setEvents()
    }

    override fun setEvents() {

//        로그아웃 버튼이 눌리면
//        로그아웃 확인(제목)/정말 로그아웃 하시겠습니다??
//        확인 => 토스트로 로그아웃 / 취소 => 아무일도 X , 버튼보유
//        사용자 의사 확인

        logoutBtn.setOnClickListener {
            val alert = AlertDialog.Builder(mContext)

            alert.setTitle("로그아웃 확인")
            alert.setMessage("정말 로그아웃을 하시겠습니까?")
            alert.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(mContext,"로그아웃",Toast.LENGTH_SHORT).show()
            })
            alert.setNegativeButton("Cancel",null)
            alert.show()
        }

    }

    override fun setValues() {

    }
}
