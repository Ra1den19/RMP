package com.example.supabase2001

import android.content.Intent
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

class UpdateActivity : AppCompatActivity() {
    lateinit var editTextId2: EditText
    lateinit var editTextName2: EditText
    lateinit var editTextEmail2: EditText
    lateinit var editTextPassword2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonNextPage2: Button = findViewById(R.id.buttonNextPage2)
        buttonNextPage2.setOnClickListener {
            val intent = Intent(this, DeleteActivity::class.java)
            startActivity(intent)
        }

        val buttonBack: Button = findViewById(R.id.buttonPreviousPage2)
        buttonBack.setOnClickListener {
            finish()
        }

        editTextId2 = findViewById<EditText>(R.id.editTextId2)
        editTextName2 = findViewById<EditText>(R.id.editTextName2)
        editTextEmail2 = findViewById<EditText>(R.id.editTextEmail2)
        editTextPassword2 = findViewById<EditText>(R.id.editTextPassword2)
    }

    fun UpdateAccount(view: View) {
        val id = editTextId2.text.toString().toInt()
        val name = editTextName2.text.toString()
        val email = editTextEmail2.text.toString()
        val password = editTextPassword2.text.toString()

        val sup = SupabaseManager()
        lifecycleScope.launch {
            sup.UpdateAccount(editTextName2.text.toString(), editTextEmail2.text.toString(), editTextPassword2.text.toString())
        }
    }
}