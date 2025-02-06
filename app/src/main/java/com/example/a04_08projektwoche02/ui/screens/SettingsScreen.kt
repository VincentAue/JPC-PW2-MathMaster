package com.example.a04_08projektwoche02.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.a04_08projektwoche02.nav.CalculateScreenRoute
import com.example.a04_08projektwoche02.nav.QuizViewRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    selectedDifficulty: MutableState<String>,
    selectedOperation: MutableState<String>,
    navController: NavController,
    modifier: Modifier
) {
    val difficulties = listOf("Easy", "Medium", "Hard", "Expert")
    val operations = listOf("+", "-", "*", "/", "Mixed")

    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Which Difficulty do you want?")

        SingleChoiceSegmentedButtonRow {
            difficulties.forEachIndexed{ index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index, count = difficulties.size),
                    onClick = {
                        selectedDifficulty.value = difficulties[index]
                        },
                    selected = label == selectedDifficulty.value
                ) {
                    Text(label)
                }
            }
        }

        Text("Which Operation?")

        SingleChoiceSegmentedButtonRow {
            operations.forEachIndexed{ index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(index, count = operations.size),
                    onClick = {
                        selectedOperation.value = operations[index]
                    },
                    selected = label == selectedOperation.value
                ) {
                    Text(label)
                }
            }
        }

        Button(
            onClick = {
                navController.navigate(CalculateScreenRoute)
            }
        ) {
            Text("Start")
        }

        Button(
            onClick = {
                navController.navigate(QuizViewRoute)
            }
        ) {
            Text("My saved Quizzes")
        }
    }
}
