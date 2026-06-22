package com.udacity.zenflow.ui.journal

import com.udacity.zenflow.data.JournalRepository
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class JournalViewModelTest {

    private val journalRepository: JournalRepository = mockk()
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun entries_updatesWhenRepositoryEmits() = runTest {
        // TODO: Verify that the ViewModel correctly exposes data from the Repository.
        // 1. Mock the repository to return a Flow of entries (using flowOf(...)).
        // 2. Create the ViewModel.
        // 3. Collect the viewModel.entries state (you might need backgroundScope.launch).
        // 4. Assert that the ViewModel's value matches the mock data.
    }

    @Test
    fun addEntry_callsRepository() = runTest {
        // TODO: Verify that adding an entry calls the repository.
        // 1. Mock the repository's addEntry method (coEvery { ... }).
        // 2. Call viewModel.addEntry("Some Content").
        // 3. Verify that journalRepository.addEntry("Some Content") was called (coVerify { ... }).
    }

    @Test
    fun addEntry_ignoresBlankContent() = runTest {
        // TODO: Verify validation logic.
        // 1. Call viewModel.addEntry("   ") (blank string).
        // 2. Verify that journalRepository.addEntry was NEVER called.
    }
}