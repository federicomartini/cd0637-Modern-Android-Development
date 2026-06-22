package com.udacity.zenflow.ui.breathing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreathingViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(BreathingUiState())
    val uiState: StateFlow<BreathingUiState> = _uiState.asStateFlow()

    // TODO: You might need a Job reference to manage the breathing cycle cancellation.
    // private var breathingJob: Job? = null

    fun toggleSession() {
        if (_uiState.value.isSessionActive) {
            stopSession()
        } else {
            startSession()
        }
    }

    private fun startSession() {
        // TODO: Implement the "4-7-8" Breathing Technique (or similar pattern).
        // 1. Update state to Active.
        // 2. Launch a coroutine to loop through the phases:
        //    - Inhale (4 seconds)
        //    - Hold (7 seconds)
        //    - Exhale (8 seconds)
        // 3. Ensure the UI updates every second if you want a countdown.

        // Note: Make sure to handle coroutine scope correctly (viewModelScope).
    }

    private fun stopSession() {
        // TODO: Cancel any active jobs and reset the UI state to IDLE.
    }

    override fun onCleared() {
        super.onCleared()
        // TODO: cleanup
    }
}

// TODO: Feel free to add more fields to this state if your UI requires it.
// e.g., progress bars, daily streaks, or different text prompts.
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