package com.hongru.basic_support

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hongru.base.view.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    companion object {
        fun launcher(context: Context) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

}
