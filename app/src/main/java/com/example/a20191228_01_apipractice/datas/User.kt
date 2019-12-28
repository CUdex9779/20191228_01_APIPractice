package com.example.a20191228_01_apipractice.datas

import org.json.JSONObject
import java.io.Serializable

class User:Serializable {

    var id = -1//숫자 int라는 것을 명시함과 동시에 id가 -1이라면 파싱에 문제가 있음을 알기 위한 초기화

    var loginId = ""
    var name = ""
    var phoneNum = ""
    var memo = ""


    companion object{
//        JSONobject를 기반으로 -> User 변수로 변환하는 기능.

        fun getUserFromJson(json:JSONObject):User{

            val parsedUser = User()

//            기본 데이터 -> json변수에서 따온 값으로 대체

            parsedUser.id = json.getInt("id")
            parsedUser.loginId = json.getString("login_id")
            parsedUser.name = json.getString("name")
            parsedUser.phoneNum = json.getString("phone")
            parsedUser.memo = json.getString("memo")

            return parsedUser

        }
    }

}