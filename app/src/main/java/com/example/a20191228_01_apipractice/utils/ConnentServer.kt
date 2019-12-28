package com.example.a20191228_01_apipractice.utils

import android.content.Context
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ConnentServer {

    interface JsonResponseHandler{
        fun onResponse(json:JSONObject)
    }


    companion object{
//        어느 서버에 연결할지 서버의 주소(도메인-ex:www.naver.com/IP주소-ex:192.168.0.10)를 변수로 저장
        val BASE_URL = "http://192.168.0.10:5000"

//        로그인 요청 기능을 함수로 구현

        fun postRequestLogin(context: Context, inputId:String, inputPw:String ,handler: JsonResponseHandler?){

            val client = OkHttpClient()

//            기본주소+기능주소(/auth) 의 조합으로 서버에 찾아갈 주소를 명시.
            val url = "${BASE_URL}/auth"

//            서버에 찾아갈 때 들고갈 데이터를 추가.
            val formBody = FormBody.Builder()
                .add("login_id",inputId)
                .add("password",inputPw)
                .build()

            val request = Request.Builder()
                .url(url)
//                    헤더(header)로 담아야 하는 데이터가 있다면 여기에.header("이름",값)추가하여야 함.
                .post(formBody)
                .build()

            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {

                    Log.d("서버연결실패",e.localizedMessage)
                }

                override fun onResponse(call: Call, response: Response) {

                    val body = response.body()!!.string()//서버에서 내려준 응답을 스트링으로 저장.
                    val json = JSONObject(body)//string으로 저장된 응답을 JSON양식으로 가공.
//                    json 변수의 내용을 분석해서 상황에 따른 처리를 할 수 있게됨.

//                    json에 대한 상세 분석이나 결과에 따른 처리를 화면(Activity)로 이관
                    handler?.onResponse(json)

                }

            })

        }

        fun getRequestMyInfo(context: Context,handler: JsonResponseHandler?){
            val client = OkHttpClient()

//            GET방식에 맞는 URL생성
//            => 파라미터가 전부 주소에 노출되도록 작성

//            urlBuilder => 단계별로 가공해서 완성하는 개념 : Builder
            val urlBuilder = HttpUrl.parse("${BASE_URL}/my_info")!!.newBuilder()
//            urlBuilder.addEncodedQueryParameter("device_token","임시값")

//            urlBuilder를 이용해 첨부된 파라미터들을 활용, url String으로 저장,
            val url = urlBuilder.build().toString()

            val request = Request.Builder()
                .url(url)
                .header("X-Http-Token" , ContextUtil.getUserToken(context))
//            GET방식은 제일 기본이 되는 API통신 방식 => 메소드를 별도로 명시X
                .build()


            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {

                    Log.d("서버연결실패",e.localizedMessage)
                }

                override fun onResponse(call: Call, response: Response) {

                    val body = response.body()!!.string()//서버에서 내려준 응답을 스트링으로 저장.
                    val json = JSONObject(body)//string으로 저장된 응답을 JSON양식으로 가공.
//                    json 변수의 내용을 분석해서 상황에 따른 처리를 할 수 있게됨.

//                    json에 대한 상세 분석이나 결과에 따른 처리를 화면(Activity)로 이관
                    handler?.onResponse(json)

                }

            })


        }

        fun getRequestUserList(context: Context,handler: JsonResponseHandler?){
            val client = OkHttpClient()

//            GET방식에 맞는 URL생성
//            => 파라미터가 전부 주소에 노출되도록 작성

//            urlBuilder => 단계별로 가공해서 완성하는 개념 : Builder
            val urlBuilder = HttpUrl.parse("${BASE_URL}/admin/user")!!.newBuilder()
            urlBuilder.addEncodedQueryParameter("active","ALL")

//            urlBuilder를 이용해 첨부된 파라미터들을 활용, url String으로 저장,
            val url = urlBuilder.build().toString()

            val request = Request.Builder()
                .url(url)
//                .header("X-Http-Token" , ContextUtil.getUserToken(context))
//            GET방식은 제일 기본이 되는 API통신 방식 => 메소드를 별도로 명시X
                .build()


            client.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {

                    Log.d("서버연결실패",e.localizedMessage)
                }

                override fun onResponse(call: Call, response: Response) {

                    val body = response.body()!!.string()//서버에서 내려준 응답을 스트링으로 저장.
                    val json = JSONObject(body)//string으로 저장된 응답을 JSON양식으로 가공.
//                    json 변수의 내용을 분석해서 상황에 따른 처리를 할 수 있게됨.

//                    json에 대한 상세 분석이나 결과에 따른 처리를 화면(Activity)로 이관
                    handler?.onResponse(json)

                }

            })


        }

    }
}