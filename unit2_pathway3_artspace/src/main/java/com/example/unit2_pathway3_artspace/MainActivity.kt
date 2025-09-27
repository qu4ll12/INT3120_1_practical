package com.example.unit2_pathway3_artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unit2_pathway3_artspace.ui.theme.MobileHomeworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileHomeworkTheme {
                Surface {
                    ArtSpaceUI()
                }
            }
        }
    }
}

data class Artwork(
    val imageRes: Int,
    val title: String,
    val artist: String,
    val year: String
)

@Composable
fun ArtSpaceUI() {
    // 1. Define a list of artworks
    val artworks = listOf(
        Artwork(R.drawable.ic_launcher_background, "Android Artwork 1", "Android", "2024"),
        Artwork(R.drawable.ic_launcher_foreground, "Compose Artwork 2", "Google", "2025"),
    )

    // 2. Declare a state variable to hold the current artwork index
    var currentArtworkIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Get the current artwork based on the index
        val currentArtwork = artworks[currentArtworkIndex]

        // 3. Pass the current artwork data to the composables
        ImageSection(currentArtwork.imageRes)
        TitleSection(currentArtwork.title, currentArtwork.artist, currentArtwork.year)

        // 4. Implement the button logic
        ButtonSection(
            onPreviousClick = {
                currentArtworkIndex = if (currentArtworkIndex > 0) {
                    currentArtworkIndex - 1
                } else {
                    artworks.size - 1
                }
            },
            onNextClick = {
                currentArtworkIndex = if (currentArtworkIndex < artworks.size - 1) {
                    currentArtworkIndex + 1
                } else {
                    0
                }
            }
        )
    }
}

@Composable
fun ImageSection(imageRes: Int, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun TitleSection(title: String, artist: String, year: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "$artist ($year)",
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}

@Composable
fun ButtonSection(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth().padding(top = 16.dp)
    ) {
        Button(onClick = onPreviousClick) {
            Text("Previous")
        }
        Button(onClick = onNextClick) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileHomeworkTheme {
        ArtSpaceUI()
    }
}