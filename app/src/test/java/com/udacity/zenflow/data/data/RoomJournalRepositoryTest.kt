package com.udacity.zenflow.data

import com.udacity.zenflow.util.TimeProvider
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Calendar

/**
 * Unit Tests for [RoomJournalRepository].
 *
 * 🎓 LEARNING MOMENT:
 * This is a "Unit Test", not an "Integration Test".
 * We are NOT using a real database here. Instead, we "Mock" the DAO.
 * This ensures we are testing the Repository logic in isolation, without side effects
 * from the Android system or SQL engine.
 */
class RoomJournalRepositoryTest {

    // @Mockk: Creates a fake version of the dependency.
    private val journalDao: JournalDao = mockk()

    // We mock TimeProvider so we can control "Time" deterministically.
    // If we used System.currentTimeMillis() inside the class, the test would be flaky!
    private val timeProvider: TimeProvider = mockk()

    // The Class Under Test (CUT)
    private val repository = RoomJournalRepository(journalDao, timeProvider)

    @Test
    fun getAllEntries_delegatesToDao() = runTest {
        // Given: The DAO is programmed to return a specific flow of data
        val expectedEntries = listOf(
            JournalEntry(id = 1, content = "Test 1"),
            JournalEntry(id = 2, content = "Test 2")
        )
        every { journalDao.getAllEntries() } returns flowOf(expectedEntries)

        // When: We ask the repository for data
        val result = repository.getAllEntries().first()

        // Then: It should pass the data through unmodified
        assertEquals(expectedEntries, result)

        // Verify: Did the repository actually call the DAO?
        coVerify { journalDao.getAllEntries() }
    }

    @Test
    fun addEntry_delegatesToDao() = runTest {
        // Given: We want to capture the argument passed to the DAO to verify it
        val content = "New Entry"
        val slot = slot<JournalEntry>()

        // 'coEvery' is used for suspend functions.
        // 'capture(slot)' grabs the object passed to insertEntry so we can inspect it later.
        coEvery { journalDao.insertEntry(capture(slot)) } returns Unit

        // When
        repository.addEntry(content)

        // Then
        coVerify { journalDao.insertEntry(any()) }
        assertEquals(content, slot.captured.content)
    }

    @Test
    fun hasEntryForToday_checksCorrectTimeRange() = runTest {
        // We freeze time to "Jan 1st, 2023 at 12:00 PM".
        val fixedTime = Calendar.getInstance().apply {
            set(2023, Calendar.JANUARY, 1, 12, 0, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        // Program the TimeProvider to return our fixed time
        every { timeProvider.currentTimeMillis() } returns fixedTime

        // Calculate what "Start of Day" means for that fixed time
        val expectedStartTime = Calendar.getInstance().apply {
            timeInMillis = fixedTime
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val expectedEndTime = expectedStartTime + 24 * 60 * 60 * 1000

        // Mock the DAO response
        coEvery { journalDao.hasEntryBetween(any(), any()) } returns true

        // When
        val result = repository.hasEntryForToday()

        // Then
        assertTrue(result)

        // Critical: Verify the Repository calculated the correct timestamps
        coVerify { journalDao.hasEntryBetween(expectedStartTime, expectedEndTime) }
    }
}