package com.example.unit3_pathway3_superheroes

/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.unit3_pathway3_superheroes.model.HeroesRepository
import com.example.unit3_pathway3_superheroes.ui.theme.SuperheroesTheme
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalConfiguration
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.saveable.rememberSaveable
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperheroesApp()
                }
            }
        }
    }

    @Composable
    fun SuperheroesApp() {
        var splitTeams by rememberSaveable { mutableStateOf(false) } // Trạng thái để điều khiển chia team

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopAppBar() },
            floatingActionButton = {
                androidx.compose.material3.FloatingActionButton(
                    onClick = { splitTeams = !splitTeams } // Toggle chia team
                ) {
                    androidx.compose.material3.Icon(
                        imageVector = androidx.compose.material.icons.Icons.Default.Add,
                        contentDescription = "Split Teams"
                    )
                }
            }
        ) { innerPadding ->
            val heroes = HeroesRepository.heroes
            val half = heroes.size / 2
            val teamA = heroes.take(half)
            val teamB = heroes.drop(half)

            val configuration = LocalConfiguration.current

            if (splitTeams) {
                when (configuration.orientation) {
                    Configuration.ORIENTATION_PORTRAIT -> {
                        Column(modifier = Modifier.padding(innerPadding)) {
                            Text(
                                text = "Team A",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.padding(8.dp)
                            )
                            HeroesList(
                                heroes = teamA,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                text = "Team B",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.padding(8.dp)
                            )
                            HeroesList(
                                heroes = teamB,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }

                    Configuration.ORIENTATION_LANDSCAPE -> {
                        Row(modifier = Modifier.padding(innerPadding)) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Team A",
                                    style = MaterialTheme.typography.headlineMedium,
                                    modifier = Modifier.padding(8.dp)
                                )
                                HeroesList(heroes = teamA)
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Team B",
                                    style = MaterialTheme.typography.headlineMedium,
                                    modifier = Modifier.padding(8.dp)
                                )
                                HeroesList(heroes = teamB)
                            }
                        }
                    }
                }
            } else {
                // Mặc định: hiển thị full danh sách
                HeroesList(heroes = heroes, contentPadding = innerPadding)
            }
        }
    }

    /**
     * Composable that displays a Top Bar with an icon and text.
     *
     * @param modifier modifiers to set to this composable
     */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBar(modifier: Modifier = Modifier) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge,
                )
            },
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun SuperHeroesPreview() {
        SuperheroesTheme {
            SuperheroesApp()
        }
    }
}