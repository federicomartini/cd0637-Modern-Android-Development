package com.udacity.zenflow.ui.breathing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.udacity.zenflow.ui.theme.ZenFlowTheme
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class BreathingScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun breathingScreen_initialState_displaysReady() {
        composeTestRule.setContent {
            ZenFlowTheme {
                BreathingScreenContent(
                    uiState = BreathingUiState(phase = BreathingPhase.IDLE),
                    onToggleSession = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Ready?").assertIsDisplayed()
    }

    @Test
    fun breathingScreen_activeState_displaysInstructions() {
        composeTestRule.setContent {
            ZenFlowTheme {
                BreathingScreenContent(
                    uiState = BreathingUiState(
                        phase = BreathingPhase.INHALE,
                        isSessionActive = true
                    ),
                    onToggleSession = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Inhale").assertIsDisplayed()
    }

    @Test
    fun breathingScreen_clickStart_displaysInhale() {
        var uiState by mutableStateOf(BreathingUiState())

        composeTestRule.setContent {
            ZenFlowTheme {
                BreathingScreenContent(
                    uiState = uiState,
                    onToggleSession = {
                        uiState = uiState.copy(
                            phase = BreathingPhase.INHALE,
                            isSessionActive = true,
                            secondsLeft = 4
                        )
                    }
                )
            }
        }

        composeTestRule.onNodeWithText("Ready?").assertIsDisplayed()
        composeTestRule.onNodeWithText("Start Breathing").performClick()
        composeTestRule.onNodeWithText("Inhale").assertIsDisplayed()
    }

    @Test
    fun breathingScreen_buttonClick_triggersCallback() {
        var clicked = false

        composeTestRule.setContent {
            ZenFlowTheme {
                BreathingScreenContent(
                    uiState = BreathingUiState(),
                    onToggleSession = { clicked = true }
                )
            }
        }

        composeTestRule.onNodeWithText("Start Breathing").performClick()

        assertTrue(clicked)
    }
}
