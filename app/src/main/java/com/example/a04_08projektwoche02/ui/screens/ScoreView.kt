package com.example.a04_08projektwoche02.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.a04_08projektwoche02.QuizViewModel
import com.example.a04_08projektwoche02.nav.SettingsScreenRoute

@Composable
fun ScoreView(
    questions: MutableList<String>,
    navController: NavController,
    vm: QuizViewModel = viewModel(),
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text("Questions in this run: ")
        questions.forEach { question ->
            Text(question)
        }
        Row(modifier = modifier) {
            Button(
                onClick = {
                    navController.navigate(SettingsScreenRoute)
                    vm.addQuiz(questions)
                }
            ) {
                Text("Save")
            }
            Button(
                onClick = {
                    navController.navigate(SettingsScreenRoute)
                    questions.removeAll { true }
                }
            ) {
                Text("Quit and delete")
            }
        }
    }
}