package com.udacity.zenflow.ui.journal

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.udacity.zenflow.data.JournalEntry
import com.udacity.zenflow.ui.theme.ZenFlowTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class JournalScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun journalScreen_displaysStaticContent() {
        composeTestRule.setContent {
            ZenFlowTheme {
                JournalScreenContent(
                    entries = emptyList(),
                    onAddEntry = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Save").assertIsDisplayed()
    }

    @Test
    fun journalScreen_inputUpdatesAndCallbackTriggered() {
        var addedEntry = ""

        composeTestRule.setContent {
            ZenFlowTheme {
                JournalScreenContent(
                    entries = emptyList(),
                    onAddEntry = { addedEntry = it }
                )
            }
        }

        composeTestRule.onNodeWithTag("journal_input").performTextInput("Test Entry")
        composeTestRule.onNodeWithText("Save").performClick()

        assertEquals("Test Entry", addedEntry)
    }

    @Test
    fun journalScreen_displaysEntries() {
        val entries = listOf(JournalEntry(id = 1, content = "Coffee"))

        composeTestRule.setContent {
            ZenFlowTheme {
                JournalScreenContent(
                    entries = entries,
                    onAddEntry = {}
                )
            }
        }

        composeTestRule.onNodeWithText("Coffee").assertIsDisplayed()
    }
}
