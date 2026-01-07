package com.example.pizzaapp3388

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTrx = fragmentManager.beginTransaction()
        fragmentTrx.replace(R.id.fragmentContainerView, fragment)
        fragmentTrx.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtAccount: TextView = findViewById(R.id.textViewMenuAccount)
        val txtMenu = findViewById<TextView>(R.id.textViewMenuMenu)
        val txtTransaction = findViewById<TextView>(R.id.textViewMenuTransaction)
        val txtReport = findViewById<TextView>(R.id.textViewMenuReport)

        txtAccount.setOnClickListener {
            replaceFragment(AccountFragment())
        }

        txtMenu.setOnClickListener {
            replaceFragment(MenuFragment())
        }

        txtTransaction.setOnClickListener {
            replaceFragment(TransactionFragment())
        }

        txtReport.setOnClickListener {
            replaceFragment(ReportFragment())
        }
    }
}