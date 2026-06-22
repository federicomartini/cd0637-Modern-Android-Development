package com.udacity.zenflow.ui.journal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.zenflow.data.JournalEntry
import com.udacity.zenflow.data.JournalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JournalViewModel @Inject constructor(
    private val journalRepository: JournalRepository
) : ViewModel() {

    // TODO: Expose the stream of entries to the UI.
    // The Repository returns a Flow<List<JournalEntry>>.
    // You should convert this to a StateFlow so the UI has a safe initial state.
    // Hint: Use .stateIn() with SharingStarted.WhileSubscribed(5000).
    val entries: StateFlow<List<JournalEntry>> = TODO("Not yet implemented")

    fun addEntry(content: String) {
        // TODO: Validate and Save.
        // 1. check if content is not blank.
        // 2. Launch a coroutine to call the repository.
    }
}