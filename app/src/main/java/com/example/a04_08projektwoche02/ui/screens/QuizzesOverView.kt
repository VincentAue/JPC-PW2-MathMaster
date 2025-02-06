package com.example.a04_08projektwoche02.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a04_08projektwoche02.QuizViewModel
import com.example.a04_08projektwoche02.R

@Composable
fun QuizzesOverView(
    vm: QuizViewModel = viewModel(),
    modifier: Modifier
){
    val quizzes by vm.quizzes.collectAsState()
    Column(
        modifier = modifier
    ) {
        Text(stringResource(R.string.your_quizzes))
        quizzes.forEach { quiz ->
            Column {
                quiz.question.forEach { question ->
                    if (question != quiz.question.last()) {
                        Text(
                            text = question
                        )
                    } else {
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = question
                            )
                            IconButton(
                                onClick = {
                                    vm.deleteQuiz(quiz)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Delete,
                                    contentDescription = Icons.Rounded.Delete.name
                                    )
                            }
                        }
                    }
                }
                HorizontalDivider(thickness = 2.dp)
            }
        }
    }
}