package com.example.supabase2001

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var editTextId: TextView
    lateinit var editTextName: EditText
    lateinit var editTextEmail: TextView
    lateinit var editTextPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonNextPage: Button = findViewById(R.id.buttonNextPage)
        buttonNextPage.setOnClickListener {
            val intent = Intent(this, UpdateActivity::class.java)
            startActivity(intent)
        }

        editTextId = findViewById<TextView>(R.id.editTextId)
        editTextName = findViewById<EditText>(R.id.editTextName)
        editTextEmail = findViewById<TextView>(R.id.editTextEmail)
        editTextPassword = findViewById<EditText>(R.id.editTextPassword)
    }

    fun SendAccount(view: View) {
        var sup = SupabaseManager()
        lifecycleScope.launch {
            sup.PostAccount(editTextName.text.toString(), editTextEmail.text.toString(), editTextPassword.text.toString())
        }
    }
}