package com.example.zapette

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class EtudiantRepondre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etudiant_repondre)

        val back_button = findViewById<ImageView>(R.id.button_back)
        back_button.setOnClickListener{
            val intent = Intent(this, EtudiantQuestionnaire::class.java)
            startActivity(intent)
            val intent2 = Intent(this, EtudiantRepondre::class.java)
            stopService(intent2)
        }
    }
}