package com.udacity.zenflow.ui.breathing

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
        // TODO: Verify the default state of the ViewModel.
        // 1. Instantiate the ViewModel.
        // 2. Assert that the initial phase is IDLE.
        // 3. Assert that the session is not active.
    }

    @Test
    fun toggleSession_startsAndStopsSession() = runTest {
        // TODO: Test the toggle logic.
        // 1. Call viewModel.toggleSession().
        // 2. Run pending coroutines (testDispatcher.scheduler.runCurrent()).
        // 3. Assert that isSessionActive is true.
        // 4. Call toggleSession() again and assert it becomes false.
    }

    @Test
    fun sessionFlow_progressesThroughPhases() = runTest {
        // TODO: (Challenge) Verify the 4-7-8 Breathing Cycle.
        // Hint: Use testDispatcher.scheduler.advanceTimeBy(milliseconds) to "fast forward" time.

        // 1. Start the session.
        // 2. Assert Phase is INHALE.
        // 3. Advance time by 4 seconds -> Assert Phase is HOLD.
        // 4. Advance time by 7 seconds -> Assert Phase is EXHALE.
        // 5. Advance time by 8 seconds -> Assert Phase loops back to INHALE.
    }
}