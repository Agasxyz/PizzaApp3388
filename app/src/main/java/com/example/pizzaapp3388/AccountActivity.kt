package com.example.pizzaapp3388

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
            val txtNama: EditText = findViewById(R.id.editTextName)
            val txtEmail: EditText = findViewById(R.id.editTextEmail)
            val txtPassword: EditText = findViewById(R.id.editTextPassword)
            val txtLevel: EditText = findViewById(R.id.editTextLevel)

            /*txtNama.setText(LoginActivity.name)
            txtEmail.setText(LoginActivity.email)
            txtPassword.setText(LoginActivity.password)
            txtLevel.setText(LoginActivity.level)*/

            //implicit intent
            //call dia number activity
            val dial: LinearLayout = findViewById(R.id.LinearLayoutCall)
            dial.setOnClickListener {
                val dialIntent: Intent = Uri.parse("tel:7777777777").let {
                        number -> Intent(Intent.ACTION_DIAL, number)
                }
                startActivity(dialIntent)
            }

            //call web
            val website = findViewById<TextView>(R.id.LinearLayoutWebsite)
            website.setOnClickListener {
                val webIntent: Intent = Uri.parse("https://home.amikom.ac.id/").let {
                        webpage -> Intent(Intent.ACTION_VIEW, webpage)
                }
                startActivity(webIntent)
            }

            //call maps
            val maps: LinearLayout = findViewById(R.id.LinearLayoutFindus)
            maps.setOnClickListener {
                val mapIntent: Intent = Uri.parse("geo:47.6,-122,3?z=11").let {
                        gmaps -> Intent(Intent.ACTION_VIEW, gmaps)
                }
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        }
    }