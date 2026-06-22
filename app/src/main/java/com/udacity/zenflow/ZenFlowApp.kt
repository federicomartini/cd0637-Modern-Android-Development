package com.udacity.zenflow

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import androidx.work.Configuration

@HiltAndroidApp
class ZenFlowApp : Application(), Configuration.Provider {

    @Inject lateinit var workerFactory: HiltWorkerFactory

    // Configuring Hilt to work with WorkManager
    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    override fun onCreate() {
        super.onCreate()
        setupRecurringWork()
    }

    private fun setupRecurringWork() {
        // TODO: Schedule your ReminderWorker here.
        // Requirements:
        // 1. Create a PeriodicWorkRequest to run once every 24 hours.
        // 2. (Optional) Add Constraints: Require the device to not be low on battery.
        // 3. Enqueue the work using WorkManager.
        //    Hint: Use 'enqueueUniquePeriodicWork' with ExistingPeriodicWorkPolicy.KEEP
        //    to avoid scheduling duplicate jobs every time the app opens.
    }
}