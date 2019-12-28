package com.example.a20191228_01_apipractice

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val mContext = this

    abstract fun setEvents()
    abstract fun setValues()

}