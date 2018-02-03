package com.example.kimayadesai.clicker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log

class MainActivity(var count: Int = 0) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickButton.setOnClickListener{ _ ->
            Log.i("rew","increase")
            count ++
            textView.text = count.toString()
        }
    }
}
