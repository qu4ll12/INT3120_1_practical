package com.example.demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.demo.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IntentDemoUI()
                }
            }
        }
    }

    @Composable
    fun IntentDemoUI() {
        Column(modifier = Modifier.padding(16.dp)) {
            // Nút mở website
            Button(
                onClick = {
                    val websiteIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"))
                    startActivity(websiteIntent)
                },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("OPEN WEBSITE")
            }

            // Nút mở Google Maps location
            Button(
                onClick = {
                    val gmmIntentUri = Uri.parse("geo:0,0?q=Golden+Gate+Bridge")
                    val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                    mapIntent.setPackage("com.google.android.apps.maps") // ép mở bằng Google Maps
                    startActivity(mapIntent)
                },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("OPEN LOCATION")
            }

            // Nút share text
            Button(
                onClick = {
                    val shareIntent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Twas brillig and the slithy toves")
                        type = "text/plain"
                    }
                    startActivity(Intent.createChooser(shareIntent, "Share via"))
                },
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text("SHARE THIS TEXT")
            }
        }
    }
}
