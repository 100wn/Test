package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import java.io.File
import java.io.FileWriter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login: EditText = findViewById(R.id.reglogin);
        val password: EditText = findViewById(R.id.passwordReg1);
        val repeatpassword: EditText = findViewById(R.id.passwordReg2);
        val button: Button = findViewById(R.id.buttonreg);
        val error1: TextView = findViewById(R.id.textView1);
        val error2: TextView = findViewById(R.id.textView2);
        val error3: TextView = findViewById(R.id.textView3);
        error1.visibility = View.GONE;
        error2.visibility = View.GONE;
        error3.visibility = View.GONE;
        fun writeToFile(text: String, fileName: String) {
            fun writeToFile(text: String, fileName: String) {
                try {
                    val file = File(fileName)
                    if (!file.exists()) {
                        file.createNewFile()
                    }
                    file.writeText(text, Charsets.UTF_8)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

        }
        button.setOnClickListener {
            error1.text = "Заполните данные";
            error2.text = "Заполните данные";
            error3.text = "Заполните данные";
            error1.visibility = View.GONE;
            error2.visibility = View.GONE;
            error3.visibility = View.GONE;
            if (login.getText().toString().equals("") || password.getText().toString()
                    .equals("") || repeatpassword.getText().toString().equals("")
            ) {
                error1.visibility = View.VISIBLE;
                error2.visibility = View.VISIBLE;
                error3.visibility = View.VISIBLE;
                return@setOnClickListener;
            }
            if (password.getText().toString() != repeatpassword.getText().toString()) {
                error2.text = "Пароли не совпадают";
                error2.visibility = View.VISIBLE;
                return@setOnClickListener;
            }
            val textToWrite = "Привет, мир!";
            val fileName = "regmobil.txt";
            writeToFile(textToWrite, fileName);
            val intent = Intent(this@MainActivity, Entrance_new::class.java);
            startActivity(intent);
            finish();
        }

    }
}
