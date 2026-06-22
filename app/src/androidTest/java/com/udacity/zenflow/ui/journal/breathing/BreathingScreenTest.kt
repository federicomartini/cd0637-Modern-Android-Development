package com.udacity.zenflow.ui.breathing

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

//Testing BreathingScreen, feel free to add more tests
class BreathingScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun breathingScreen_initialState_displaysReady() {
        // TODO: Verify the UI in the IDLE state.
        // 1. Create a BreathingUiState with phase = BreathingPhase.IDLE.
        // 2. Set the content using 'composeTestRule.setContent'.
        //    - Pass the state to 'BreathingScreenContent'.
        // 3. Use 'onNodeWithText("Ready?")' (or your specific IDLE text) to assert it is displayed.
    }

    @Test
    fun breathingScreen_activeState_displaysInstructions() {
        // TODO: Verify the UI updates when the state changes.
        // 1. Create a BreathingUiState with phase = BreathingPhase.INHALE.
        // 2. Set the content.
        // 3. Assert that the text "Inhale" is displayed on screen.
    }

    @Test
    fun breathingScreen_buttonClick_triggersCallback() {
        // TODO: Verify interaction.
        // 1. Create a variable 'var clicked = false'.
        // 2. Set the content, passing a lambda { clicked = true } for 'onToggleSession'.
        // 3. Find the Start/Stop button using 'onNodeWithText' (or a testTag).
        // 4. Perform a click action (.performClick()).
        // 5. Assert that 'clicked' is now true.
    }
}