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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.a04_08projektwoche02.R
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
    val difficulties = listOf(
        stringResource(R.string.easy),
        stringResource(R.string.medium),
        stringResource(R.string.hard),
        stringResource(R.string.expert)
    )
    val operations = listOf("+", "-", "*", "/", stringResource(R.string.mixed))

    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(stringResource(R.string.which_difficulty))

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

        Text(stringResource(R.string.which_operation))

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
            Text(stringResource(R.string.start))
        }

        Button(
            onClick = {
                navController.navigate(QuizViewRoute)
            }
        ) {
            Text(stringResource(R.string.my_saved_quizzes))
        }
    }
}
