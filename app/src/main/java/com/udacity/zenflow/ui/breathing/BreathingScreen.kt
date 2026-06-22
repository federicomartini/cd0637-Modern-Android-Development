package com.udacity.zenflow.ui.breathing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun BreathingScreen(
    viewModel: BreathingViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    // Pass the state and events to the stateless "Content" composable.
    BreathingScreenContent(
        uiState = uiState,
        onToggleSession = { viewModel.toggleSession() }
    )
}

// TODO: Implement this "Stateless" composable.
// separation of concerns allows us to test the UI without needing a real ViewModel.
@Composable
fun BreathingScreenContent(
    uiState: BreathingUiState,
    onToggleSession: () -> Unit
) {
    // TODO: Define your Animation State here.
    // Hint: Use 'animateFloatAsState' or 'Animatable' to drive visual changes based on 'uiState.phase'.

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // TODO: Build your Breathing UI!
        // Requirements:
        // 1. A custom visual indicator that grows (Inhale), pauses (Hold), and shrinks (Exhale).
        //    (This could be a Circle, a Flower, a Cloud, a Bar—be creative!)

        // 2. Text instructions telling the user what to do (Inhale/Exhale).

        // 3. A control (Button/Clickable) to Start and Stop the session.
    }
}