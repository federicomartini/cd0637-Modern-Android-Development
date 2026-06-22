package com.udacity.zenflow.ui.journal

import com.udacity.zenflow.data.JournalEntry
import com.udacity.zenflow.data.JournalRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
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
        val expectedEntries = listOf(
            JournalEntry(id = 1, content = "Coffee"),
            JournalEntry(id = 2, content = "Sunshine")
        )
        every { journalRepository.getAllEntries() } returns flowOf(expectedEntries)

        val viewModel = JournalViewModel(journalRepository)

        val collectJob = backgroundScope.launch {
            viewModel.entries.collect { }
        }
        runCurrent()

        assertEquals(expectedEntries, viewModel.entries.value)
        collectJob.cancel()
    }

    @Test
    fun addEntry_callsRepository() = runTest {
        every { journalRepository.getAllEntries() } returns flowOf(emptyList())
        coEvery { journalRepository.addEntry(any()) } returns Unit

        val viewModel = JournalViewModel(journalRepository)
        viewModel.addEntry("Some Content")
        runCurrent()

        coVerify { journalRepository.addEntry("Some Content") }
    }

    @Test
    fun addEntry_ignoresBlankContent() = runTest {
        every { journalRepository.getAllEntries() } returns flowOf(emptyList())

        val viewModel = JournalViewModel(journalRepository)
        viewModel.addEntry("   ")
        runCurrent()

        coVerify(exactly = 0) { journalRepository.addEntry(any()) }
    }
}
