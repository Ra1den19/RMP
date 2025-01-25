package com.example.supabase2001

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class DeleteActivity : AppCompatActivity() {
    lateinit var editTextId3: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_delete)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonBack: Button = findViewById(R.id.buttonPreviousPage)
        buttonBack.setOnClickListener {
            finish()
        }

        editTextId3 = findViewById<EditText>(R.id.editTextId3)
    }

    fun DeleteAccount(view: View) {
        val id = editTextId3.text.toString().toInt()

        val sup = SupabaseManager()
        lifecycleScope.launch {
            sup.DeleteAccount(id)
        }
    }
}