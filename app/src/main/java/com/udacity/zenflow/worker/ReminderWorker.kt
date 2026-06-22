package com.udacity.zenflow.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.udacity.zenflow.data.JournalRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class ReminderWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val journalRepository: JournalRepository
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        // TODO: Implement the Background Work.
        // 1. Check if the user has already journaled today (use journalRepository.hasEntryForToday()).
        // 2. If they have NOT journaled, call showNotification().
        // 3. Handle exceptions and return Result.success() or Result.retry().

        return Result.success()
    }

    private fun showNotification() {
        // TODO: Create and display a Notification.
        // Requirements:
        // 1. Get reference to NotificationManager.
        // 2. Create a NotificationChannel (Required for Android O+).
        //    - ID: "reflection_channel"
        //    - Name: "Reflection Reminders"
        //    - Importance: Default
        // 3. Build the Notification using NotificationCompat.Builder.
        //    - Set Title: "Time to Reflect"
        //    - Set Text: "You haven't journaled today..."
        //    - Set SmallIcon.
        // 4. Show the notification using .notify().

        // (Bonus): Add a PendingIntent so clicking the notification opens the app.
    }
}