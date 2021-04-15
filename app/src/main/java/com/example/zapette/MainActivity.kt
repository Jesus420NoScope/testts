package com.example.zapette

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonEtudiant = findViewById<Button>(R.id.buttonStudent)
        buttonEtudiant.setOnClickListener{
            val intent = Intent(this, EtudiantQuestionnaire::class.java)
            startActivity(intent)
        }


    }


}