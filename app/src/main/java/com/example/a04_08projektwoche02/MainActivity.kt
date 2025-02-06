package com.example.a04_08projektwoche02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.a04_08projektwoche02.ui.screens.MathMasterApp
import com.example.a04_08projektwoche02.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                MathMasterApp()
            }
        }
    }
}
