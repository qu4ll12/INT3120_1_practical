package com.example.musicdemo

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.musicdemo.R

class MainActivity : ComponentActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mediaPlayer = MediaPlayer.create(this, R.raw.sample_music)

        setContent {
            MusicPlayerUI(
                onPlay = { mediaPlayer?.start() },
                onPause = { mediaPlayer?.pause() }
            )
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}

@Composable
fun MusicPlayerUI(onPlay: () -> Unit, onPause: () -> Unit) {
    var isPlaying by remember { mutableStateOf(false) }

    Button(onClick = {
        if (isPlaying) {
            onPause()
        } else {
            onPlay()
        }
        isPlaying = !isPlaying
    }) {
        Text(if (isPlaying) "Pause" else "Play")
    }
}
