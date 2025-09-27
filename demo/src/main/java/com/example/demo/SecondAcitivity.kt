package com.example.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.demo.ui.theme.BusinessCardTheme
import androidx.compose.foundation.layout.padding

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Nhận dữ liệu từ Intent
        val username = intent.getStringExtra("username")
        val age = intent.getIntExtra("age", -1)

        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Text(
                    text = "Xin chào $username, tuổi $age",
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}
