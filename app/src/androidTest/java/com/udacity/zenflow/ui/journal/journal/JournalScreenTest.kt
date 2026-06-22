package com.udacity.zenflow.ui.journal

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

//Testing JournalScreen, feel free to add more tests
class JournalScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun journalScreen_displaysStaticContent() {
        // TODO: Verify the static UI elements (like the Save button).
        // 1. Set the content using 'JournalScreenContent' with an empty list.
        // 2. Assert that the "Save" button (or "Add Entry" button) is displayed.
    }

    @Test
    fun journalScreen_inputUpdatesAndCallbackTriggered() {
        // TODO: Verify input interaction.
        // 1. Create a variable to capture the output: 'var addedEntry = ""'.
        // 2. Set the content, passing a lambda { addedEntry = it } for 'onAddEntry'.

        // 3. Find the text input field.
        //    *CRITICAL HINT*: In your JournalScreen.kt, did you add 'Modifier.testTag("journal_input")'?
        //    Use 'onNodeWithTag("journal_input")' to find it.

        // 4. Perform text input: .performTextInput("My Gratitude").
        // 5. Find and Click the Save button.
        // 6. Assert that 'addedEntry' matches "My Gratitude".
    }

    @Test
    fun journalScreen_displaysEntries() {
        // TODO: Verify List rendering.
        // 1. Create a list containing one JournalEntry (e.g., content = "Coffee").
        // 2. Set the content passing this list.
        // 3. Assert that the text "Coffee" exists and is displayed on the screen.
    }
}