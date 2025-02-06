package com.example.a04_08projektwoche02

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.a04_08projektwoche02.data.local.Quiz
import com.example.a04_08projektwoche02.data.local.QuizDatabase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class QuizViewModel(application: Application): AndroidViewModel(application) {

    private val dao = QuizDatabase.getDatabase(application.applicationContext).dao()

    val quizzes: StateFlow<List<Quiz>> = dao.getAllQuizzes()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = emptyList()
        )

    fun addQuiz(questions: MutableList<String>) {
        viewModelScope.launch {
            dao.insertQuiz(Quiz(question = questions))

            questions.removeAll { true }
        }
    }

    fun deleteQuiz(quiz: Quiz){
        viewModelScope.launch {
            dao.deleteQuiz(quiz)
        }
    }
}