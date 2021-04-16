package com.example.zapette

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.config.GservicesValue.value
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
        var codeUtilisateur = ""
        var codeBDD = ""
        var should = false

        val back_button = findViewById<ImageView>(R.id.button_back)
        back_button.setOnClickListener{
            startActivity(intent)
        }

        //Récupérer le code saisi par l'utilisateur


        val buttonRejoindre = findViewById<Button>(R.id.button_rejoindre)
        buttonRejoindre.setOnClickListener{

            val editText = findViewById<EditText>(R.id.zone_saisie_code)
            val codesaisi = editText.text
            //TODO: Si codesaisi vide, redémarrer l'activity avec message d'erreur vide

            ref_questionnaire.child("code").get().addOnSuccessListener {
                codeBDD = it.value.toString()
            }.addOnFailureListener{
                Toast.makeText(applicationContext, "Ya pa de le code", LENGTH_LONG).show()
            }

            if (codeUtilisateur == codeBDD){
                startActivity(intent2)
            }

        }

    }

}