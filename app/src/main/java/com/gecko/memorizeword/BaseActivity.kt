package com.gecko.memorizeword

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext: Context

//    lateinit var retrofit: Retrofit
//    lateinit var apiService: ServerAPIService
//
//    lateinit var actionBarTitleTxt: TextView
//    lateinit var actionBarPageNameTxt: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this

//        retrofit = ServerAPI.getRetrofit(mContext)
//        apiService = retrofit.create(ServerAPIService::class.java)
//
//        supportActionBar?.let {
//            setCustomActionBar()
//        }
    }

    override fun onStart() {
        super.onStart()

//        val rootView = window.decorView.rootView
//        FontChanger.setGlobalFont(mContext, rootView)
    }

    abstract fun setupEvents()
    abstract fun setValues()
//    abstract fun setActionBar()

//    fun setCustomActionBar() {
//
//        val defActionBar = supportActionBar!!
//
//        defActionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
//        defActionBar.setCustomView(R.layout.custom_action_bar)
//
//        val toolbar = defActionBar.customView.parent as Toolbar
//        toolbar.setContentInsetsAbsolute(0, 0)
//
//        actionBarTitleTxt = defActionBar.customView.findViewById(R.id.actionTitleTxt)
//        actionBarPageNameTxt = defActionBar.customView.findViewById(R.id.actionPageNameTxt)
//
//        actionBarBackImg.setOnClickListener {
//            finish()
//        }
//
//    }

}