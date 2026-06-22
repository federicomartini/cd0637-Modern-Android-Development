package com.udacity.zenflow.ui.journal

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.udacity.zenflow.data.JournalEntry

@Composable
fun JournalScreen(
    viewModel: JournalViewModel = hiltViewModel()
) {
    val entries by viewModel.entries.collectAsState()

    JournalScreenContent(
        entries = entries,
        onAddEntry = { content -> viewModel.addEntry(content) }
    )
}

// TODO: Implement this "Stateless" composable for easier testing.
@Composable
fun JournalScreenContent(
    entries: List<JournalEntry>,
    onAddEntry: (String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // TODO: Build the Journal UI.

        // 1. INPUT AREA:
        //    - TextField for typing gratitude.
        //      *IMPORTANT*: Add 'Modifier.testTag("journal_input")' to your TextField
        //      so the automated tests can find it!
        //    - Button to save (calls onAddEntry).

        // 2. LIST AREA:
        //    - LazyColumn to display 'entries'.
    }
}