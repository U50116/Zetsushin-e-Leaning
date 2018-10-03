package com.example.enpit_p33.zetsushinleaning

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val set_id = intent.getStringExtra("ID")

        Text.text = set_id
        startButton.setOnClickListener{ onStartButtonTapped()}
    }

    fun onStartButtonTapped(){
        val intent = Intent(this,AlphaActivity::class.java)
        startActivity(intent)
    }

}
