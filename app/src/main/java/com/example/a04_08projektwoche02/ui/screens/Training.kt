package com.example.a04_08projektwoche02.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.a04_08projektwoche02.nav.CalculateScreenRoute
import com.example.a04_08projektwoche02.nav.ScoreViewRoute
import kotlin.random.Random

@Composable
fun Training(
    selectedDifficulty: MutableState<String>,
    selectedOperation: MutableState<String>,
    questions: MutableList<String>,
    navController: NavController
) {

    var userInput by remember { mutableStateOf("") }

    val range = when (selectedDifficulty.value) {
        "Easy" -> 1 to 20
        "Medium" -> 21 to 50
        "Hard" -> 51 to 100
        else -> 101 to 200
    }

    val generatedNumber1 = remember(selectedDifficulty.value, selectedOperation.value) {
        Random.nextInt(range.first, range.second)
    }
    val generatedNumber2 = remember(selectedDifficulty.value, selectedOperation.value) {
        Random.nextInt(range.first, range.second)
    }

    val randomOp = remember (selectedDifficulty.value, selectedOperation.value) {
        listOf("+", "-", "*", "/").random()
    }

    val question = if (selectedOperation.value != "Mixed") {
        "$generatedNumber1 ${selectedOperation.value} $generatedNumber2"
    } else {
        "$generatedNumber1 $randomOp $generatedNumber2"
    }

    val result: Double = when (selectedOperation.value.takeIf { it != "Mixed" } ?: randomOp) {
        "+" -> {
            generatedNumber1.toDouble() + generatedNumber2
        }
        "-" -> {
            generatedNumber1.toDouble() - generatedNumber2
        }
        "*" -> {
            generatedNumber1.toDouble() * generatedNumber2
        }
        "/" -> {
            generatedNumber1.toDouble() / generatedNumber2
        }
        else -> 0.0
    }
    val textColor = MaterialTheme.colorScheme.onBackground

    var questionColor by remember { mutableStateOf(textColor) }
    Column {
        Text("Your Challenge")
        Text(
            text = "$question = $userInput",
            color = questionColor
        )
        if(selectedOperation.value == "/") {
            Text("If the ratio has more than two decimal places, " +
                    "write only the first two digits without rounding.")
        }
        Row {
            TextField(
                value = userInput,
                onValueChange = { userInput = it },
                label = { Text("Result") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Button(
            onClick = {
                questionColor = if (result.toString().take(4) == (userInput.toDouble()).toString().take(4)) {
                    Color.Green
                } else {
                    Color.Red
                }
            },
            enabled = userInput != ""
        ) {
            Text("Answer")
        }

        if (questionColor != Color.Green) {
            Text("For the next Challenge or for concluding the training, " +
                    "you must complete this question first.")
        }

        Button(
            onClick = {
                questions.add(question)
                navController.navigate(CalculateScreenRoute)
            },
            enabled = questionColor == Color.Green
        ) {
            Text("New Challenge")
        }

        Button(
            onClick = {
                questions.add(question)
                navController.navigate(ScoreViewRoute)
            },
            enabled = questionColor == Color.Green
        ) {
            Text("Conclude Training")
        }
    }
}
