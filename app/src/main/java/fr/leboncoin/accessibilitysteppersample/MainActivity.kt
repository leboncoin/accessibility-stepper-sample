package fr.leboncoin.accessibilitysteppersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fr.leboncoin.accessibilitysteppersample.ui.MainNavHost
import fr.leboncoin.accessibilitysteppersample.ui.theme.AccessibilityStepperSampleTheme

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
