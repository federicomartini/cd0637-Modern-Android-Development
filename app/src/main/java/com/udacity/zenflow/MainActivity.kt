package com.udacity.zenflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.udacity.zenflow.ui.AppNavigation
import com.udacity.zenflow.ui.theme.ZenFlowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // TODO: You might need a launcher to request permissions (Android 13+ Notifications).
    // private val requestPermissionLauncher = ...

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Request the POST_NOTIFICATIONS permission if the device is running Android 13 (Tiramisu) or higher.
        // This is required for your ReminderWorker to actually show anything.

        setContent {
            ZenFlowTheme {
                // The main entry point to your Compose UI
                AppNavigation()
            }
        }
    }
}