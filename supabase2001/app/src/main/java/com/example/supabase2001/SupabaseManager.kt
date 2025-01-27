package com.example.supabase2001

import android.net.http.HttpResponseCache.install
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.core.sym.Name
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.serializer.JacksonSerializer

class SupabaseManager : AppCompatActivity() {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://mpeuhbzczcbiqxbsxwef.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im1wZXVoYnpjemNiaXF4YnN4d2VmIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzcxODA5MTAsImV4cCI6MjA1Mjc1NjkxMH0.Aa-Gs7gqQmtQ_97_NbOnGJIN5JgNJsLerDHKYK5hst8"
    ) {
        install(Postgrest)
        defaultSerializer = JacksonSerializer()
    }

    suspend fun GetAccounts(): List<Account>{
        return supabase.from("account").select().decodeList<Account>()
    }

    suspend fun PostAccount(Name: String, Email: String, Password: String){
        supabase.postgrest["account"].insert(mapOf(
            "Name" to Name,
            "Email" to Email,
            "Password" to Password
        ))
    }

    suspend fun UpdateAccount(Name: String, Email: String, Password: String) {
        supabase.from("account").update(mapOf(
            "Name" to Name,
            "Email" to Email,
            "Password" to Password
        ))
    }

    suspend fun DeleteAccount(id: Int) {
        supabase.from("account").delete {
            filter {
                eq("id", 666)
            }
        }
    }
}

data class Account(
    val id: Int,
    val Name: String,
    val Email: String,
    val Password: String
)