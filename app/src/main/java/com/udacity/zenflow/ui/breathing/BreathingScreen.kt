package com.udacity.zenflow.ui.breathing

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.udacity.zenflow.R

@Composable
fun BreathingScreen(
    viewModel: BreathingViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    BreathingScreenContent(
        uiState = uiState,
        onToggleSession = { viewModel.toggleSession() }
    )
}

@Composable
fun BreathingScreenContent(
    uiState: BreathingUiState,
    onToggleSession: () -> Unit
) {
    val targetScale = when (uiState.phase) {
        BreathingPhase.IDLE -> 1f
        BreathingPhase.INHALE -> 1.4f
        BreathingPhase.HOLD -> 1.4f
        BreathingPhase.EXHALE -> 0.75f
    }
    val scale by animateFloatAsState(
        targetValue = targetScale,
        animationSpec = tween(durationMillis = 1000),
        label = "breathingScale"
    )

    val targetAlpha = when (uiState.phase) {
        BreathingPhase.HOLD -> 0.65f
        BreathingPhase.EXHALE -> 0.85f
        else -> 1f
    }
    val alpha by animateFloatAsState(
        targetValue = targetAlpha,
        animationSpec = tween(durationMillis = 1000),
        label = "breathingAlpha"
    )

    val circleColor = when (uiState.phase) {
        BreathingPhase.INHALE -> MaterialTheme.colorScheme.primary
        BreathingPhase.HOLD -> MaterialTheme.colorScheme.tertiary
        BreathingPhase.EXHALE -> MaterialTheme.colorScheme.secondary
        BreathingPhase.IDLE -> MaterialTheme.colorScheme.primaryContainer
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .scale(scale)
                    .alpha(alpha)
                    .background(color = circleColor, shape = CircleShape)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = uiState.phase.instruction,
                style = MaterialTheme.typography.headlineMedium
            )

            if (uiState.isSessionActive && uiState.secondsLeft > 0) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = uiState.secondsLeft.toString(),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = onToggleSession) {
                Text(
                    text = if (uiState.isSessionActive) {
                        stringResource(R.string.stop_session)
                    } else {
                        stringResource(R.string.start_breathing)
                    }
                )
            }
        }
    }
}
