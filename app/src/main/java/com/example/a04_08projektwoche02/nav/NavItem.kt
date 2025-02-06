package com.example.a04_08projektwoche02.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavItem(
    val route: Any,
    val label: String,
    val icon: ImageVector
) {
    Settings(
        route = SettingsScreenRoute,
        label = "Settings",
        icon = Icons.Rounded.Settings
    ),
    Calculate(
        route = CalculateScreenRoute,
        label = "Calculate",
        icon = Icons.Rounded.Calculate
    ),
    Score(
        route = ScoreViewRoute,
        label = "Scoreboard",
        icon = Icons.AutoMirrored.Rounded.List
    ),
    Quiz(
        route = QuizViewRoute,
        label = "Quizzes",
        icon = Icons.Rounded.CheckCircle
    )
}