package com.example.a20191228_01_apipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.ConnectionService
import android.widget.Toast
import com.example.a20191228_01_apipractice.datas.User
import com.example.a20191228_01_apipractice.utils.ConnentServer
import org.json.JSONObject
import java.net.ConnectException

class MainActivity : BaseActivity() {

    var userList = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setEvents()
        setValues()
    }

    override fun setEvents() {

    }

    override fun setValues() {

    }

    override fun onResume() {
        super.onResume()

        ConnentServer.getRequestUserList(mContext,object : ConnentServer.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {

                val code = json.getInt("code")
                runOnUiThread{

                    if (code == 200){

                        val data = json.getJSONObject("data")
                        val users = data.getJSONArray("users")

                        for (i in 0..(users.length()-1)){
                            val userJson = users.getJSONObject(i)

                            val userDataObject = User.getUserFromJson(userJson)

                            userList.add(userDataObject)



                        }

                    }
                    else{
                        Toast.makeText(mContext,"서버에문제가있습니다.",Toast.LENGTH_SHORT).show()
                    }

                }

            }

        })
    }


}
