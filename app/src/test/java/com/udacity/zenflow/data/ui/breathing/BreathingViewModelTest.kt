package com.udacity.zenflow.ui.breathing

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class BreathingViewModelTest {

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
    fun initialState_isIdle() {
        val viewModel = BreathingViewModel()

        assertEquals(BreathingPhase.IDLE, viewModel.uiState.value.phase)
        assertFalse(viewModel.uiState.value.isSessionActive)
    }

    @Test
    fun toggleSession_startsAndStopsSession() = runTest {
        val viewModel = BreathingViewModel()

        viewModel.toggleSession()
        runCurrent()
        assertTrue(viewModel.uiState.value.isSessionActive)

        viewModel.toggleSession()
        runCurrent()
        assertFalse(viewModel.uiState.value.isSessionActive)
    }

    @Test
    fun sessionFlow_progressesThroughPhases() {
        val viewModel = BreathingViewModel()

        viewModel.toggleSession()
        testDispatcher.scheduler.runCurrent()
        assertEquals(BreathingPhase.INHALE, viewModel.uiState.value.phase)

        testDispatcher.scheduler.advanceTimeBy(4_000)
        testDispatcher.scheduler.runCurrent()
        assertEquals(BreathingPhase.HOLD, viewModel.uiState.value.phase)

        testDispatcher.scheduler.advanceTimeBy(7_000)
        testDispatcher.scheduler.runCurrent()
        assertEquals(BreathingPhase.EXHALE, viewModel.uiState.value.phase)

        testDispatcher.scheduler.advanceTimeBy(8_000)
        testDispatcher.scheduler.runCurrent()
        assertEquals(BreathingPhase.INHALE, viewModel.uiState.value.phase)

        viewModel.toggleSession()
        testDispatcher.scheduler.runCurrent()
        assertFalse(viewModel.uiState.value.isSessionActive)
    }
}
