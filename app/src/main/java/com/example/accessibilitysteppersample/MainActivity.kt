package com.example.accessibilitysteppersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.accessibilitysteppersample.ui.MainNavHost
import com.example.accessibilitysteppersample.ui.theme.AccessibilityStepperSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AccessibilityStepperSampleTheme {
                MainNavHost()
            }
        }
    }
}
