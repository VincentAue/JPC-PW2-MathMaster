package com.example.a04_08projektwoche02.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a04_08projektwoche02.nav.CalculateScreenRoute
import com.example.a04_08projektwoche02.nav.NavItem
import com.example.a04_08projektwoche02.nav.QuizViewRoute
import com.example.a04_08projektwoche02.nav.ScoreViewRoute
import com.example.a04_08projektwoche02.nav.SettingsScreenRoute

@Composable
fun MathMasterApp(
) {

    val navController = rememberNavController()
    val selectedNavItem by rememberSaveable { mutableStateOf(NavItem.Settings) }

    val selectedDifficulty = remember { mutableStateOf("Easy") }
    val selectedOperation = remember { mutableStateOf("+") }

    val questions = remember { mutableListOf<String>() }

    Scaffold { innerPadding ->
        Column {
            NavHost(
                navController = navController,
                startDestination = selectedNavItem.route
            ) {
                composable<SettingsScreenRoute> {
                    SettingsScreen(
                        selectedDifficulty = selectedDifficulty,
                        selectedOperation = selectedOperation,
                        navController = navController,
                        modifier = Modifier .fillMaxSize() .padding(innerPadding)
                    )
                }
                composable<CalculateScreenRoute> {
                    CalculateScreen(
                        selectedDifficulty = selectedDifficulty,
                        selectedOperation = selectedOperation,
                        questions = questions,
                        navController = navController
                    )
                }
                composable<ScoreViewRoute> {
                    ScoreView(
                        navController = navController,
                        modifier = Modifier .fillMaxSize() .padding(innerPadding),
                        questions = questions
                    )
                }
                composable<QuizViewRoute> {
                    QuizzesOverView(
                        modifier = Modifier .fillMaxSize() .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMathApp(){
    MathMasterApp()
}