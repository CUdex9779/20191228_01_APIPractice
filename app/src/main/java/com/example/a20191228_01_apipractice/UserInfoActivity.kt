package com.example.a20191228_01_apipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a20191228_01_apipractice.datas.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_user_info.*

class UserInfoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        setEvents()
        setValues()
    }

    override fun setEvents() {



    }

    override fun setValues() {


        val userInfo = intent.getSerializableExtra("user") as User

        userIdTxt.text = userInfo.loginId
        userNameTxt.text = userInfo.name
        userPhoneTxt.text = userInfo.phoneNum
        userMemoTxt.text = userInfo.memo

    }


}
