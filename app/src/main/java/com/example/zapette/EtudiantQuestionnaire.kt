package com.example.zapette

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import android.widget.Toast.makeText as makeText1


class EtudiantQuestionnaire() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etudiant_questionnaire)

        val database = FirebaseDatabase.getInstance()
        val ref_questionnaire = database.getReference("Questionnaire")
        val intent = Intent(this, MainActivity::class.java)
        val intent2 = Intent(this, EtudiantRepondre::class.java)


        val back_button = findViewById<ImageView>(R.id.button_back)
        back_button.setOnClickListener{
            startActivity(intent)
        }


        val buttonRejoindre = findViewById<Button>(R.id.button_rejoindre)
        buttonRejoindre.setOnClickListener{

            /*
            ecrire dans une bdd

            val myRef = database.getReference("Questionnaire")
            myRef.setValue("9999")
            */

            //lire dans une bdd
            ref_questionnaire.addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()){
                        val code : Any?
                        code = snapshot.getValue()
                        Toast.makeText(applicationContext, code.toString().toInt(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    startActivity(intent)
                }
            })

            startActivity(intent2)
        }


    }

}