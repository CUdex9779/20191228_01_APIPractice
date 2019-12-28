package com.example.a20191228_01_apipractice

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.a20191228_01_apipractice.datas.User
import com.example.a20191228_01_apipractice.utils.ConnentServer
import com.example.a20191228_01_apipractice.utils.ContextUtil
import kotlinx.android.synthetic.main.activity_my_profile.*
import org.json.JSONObject

class MyProfileActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)


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

                ContextUtil.setUserToken(mContext,"")

                val intent = Intent(mContext,LoginActivity::class.java)
                startActivity(intent)

                finish()
            })
            alert.setNegativeButton("Cancel",null)
            alert.show()
        }

    }

    override fun setValues() {

        ConnentServer.getRequestMyInfo(mContext,object : ConnentServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("내정보서버응답",json.toString())

                val code = json.getInt("code")

                runOnUiThread{

                    if (code == 200){

                        val data = json.getJSONObject("data")
                        val user = data.getJSONObject("user")

                        val loginUser = User.getUserFromJson(user)


                        nameTxt.text = loginUser.name
                        phoneTxt.text = loginUser.phoneNum
                        loginIdTxt.text = loginUser.loginId
                    }
                    else{
                        Toast.makeText(mContext,"서버에 문제가 있습니다.",Toast.LENGTH_SHORT).show()
                    }

                }

            }

        })

    }
}
