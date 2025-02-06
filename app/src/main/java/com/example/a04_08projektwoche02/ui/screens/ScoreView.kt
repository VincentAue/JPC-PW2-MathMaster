package com.example.a04_08projektwoche02.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.a04_08projektwoche02.QuizViewModel
import com.example.a04_08projektwoche02.R
import com.example.a04_08projektwoche02.nav.SettingsScreenRoute

@Composable
fun ScoreView(
    questions: MutableList<String>,
    navController: NavController,
    vm: QuizViewModel = viewModel(),
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Text(stringResource(R.string.questions_in_this_run))
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
                Text(stringResource(R.string.save))
            }
            Button(
                onClick = {
                    navController.navigate(SettingsScreenRoute)
                    questions.removeAll { true }
                }
            ) {
                Text(stringResource(R.string.quit_and_delete))
            }
        }
    }
}