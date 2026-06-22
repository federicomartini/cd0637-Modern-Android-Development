package com.udacity.zenflow.ui.breathing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import javax.inject.Inject

@HiltViewModel
class BreathingViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(BreathingUiState())
    val uiState: StateFlow<BreathingUiState> = _uiState.asStateFlow()

    private var breathingJob: Job? = null

    fun toggleSession() {
        if (_uiState.value.isSessionActive) {
            stopSession()
        } else {
            startSession()
        }
    }

    private fun startSession() {
        breathingJob?.cancel()
        _uiState.value = _uiState.value.copy(isSessionActive = true)

        breathingJob = viewModelScope.launch {
            while (_uiState.value.isSessionActive && isActive) {
                runPhase(BreathingPhase.INHALE, INHALE_SECONDS)
                runPhase(BreathingPhase.HOLD, HOLD_SECONDS)
                runPhase(BreathingPhase.EXHALE, EXHALE_SECONDS)
            }
        }
    }

    private suspend fun runPhase(phase: BreathingPhase, durationSeconds: Int) {
        _uiState.value = _uiState.value.copy(
            phase = phase,
            phaseDuration = durationSeconds * 1000L,
            secondsLeft = durationSeconds
        )
        repeat(durationSeconds) { elapsed ->
            delay(1_000)
            if (!coroutineContext.isActive || !_uiState.value.isSessionActive) return
            val remaining = durationSeconds - elapsed - 1
            if (remaining > 0) {
                _uiState.value = _uiState.value.copy(secondsLeft = remaining)
            }
        }
    }

    private fun stopSession() {
        _uiState.value = BreathingUiState()
        breathingJob?.cancel()
        breathingJob = null
    }

    override fun onCleared() {
        breathingJob?.cancel()
        super.onCleared()
    }

    companion object {
        private const val INHALE_SECONDS = 4
        private const val HOLD_SECONDS = 7
        private const val EXHALE_SECONDS = 8
    }
}

data class BreathingUiState(
    val phase: BreathingPhase = BreathingPhase.IDLE,
    val isSessionActive: Boolean = false,
    val phaseDuration: Long = 0L,
    val secondsLeft: Int = 0
)

enum class BreathingPhase(val instruction: String) {
    IDLE("Ready?"),
    INHALE("Inhale"),
    HOLD("Hold"),
    EXHALE("Exhale")
}
