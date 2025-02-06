package com.example.a04_08projektwoche02.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CalculateScreen(
    selectedDifficulty: MutableState<String>,
    selectedOperation: MutableState<String>,
    questions: MutableList<String>,
    navController: NavController
) {
    Column {
        MyTopBar(
            navController = navController
        )
        Training(
            selectedOperation = selectedOperation,
            selectedDifficulty = selectedDifficulty,
            questions = questions,
            navController = navController
        )
    }
}
