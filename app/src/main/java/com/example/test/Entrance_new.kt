package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Entrance_new : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance_new)

        val button_reg:Button = findViewById(R.id.regbutton)

        button_reg.setOnClickListener{
            val intent = Intent(this@Entrance_new, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}