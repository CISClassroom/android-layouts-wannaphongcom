package com.numfa.androidlayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1.setOnClickListener {
            val i = Intent(this, L2::class.java)
            startActivity(i)
        }
        b2.setOnClickListener {
            val i = Intent(this, LinearActivity::class.java)
            startActivity(i)
        }
        b3.setOnClickListener {
            val i = Intent(this, LinearActivity::class.java)
            startActivity(i)
        }
    }
}
