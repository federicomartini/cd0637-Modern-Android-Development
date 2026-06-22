package com.udacity.zenflow.data

import com.udacity.zenflow.util.TimeProvider

import kotlinx.coroutines.flow.Flow
import java.util.Calendar
import javax.inject.Inject

class RoomJournalRepository @Inject constructor(
    private val journalDao: JournalDao,
    private val timeProvider: TimeProvider
) : JournalRepository {

    override fun getAllEntries(): Flow<List<JournalEntry>> {
        return journalDao.getAllEntries()
    }

    override suspend fun addEntry(content: String) {
        journalDao.insertEntry(JournalEntry(content = content))
    }

    override suspend fun hasEntryForToday(): Boolean {
        val now = timeProvider.currentTimeMillis()
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = now
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val startTime = calendar.timeInMillis

        val endTime = startTime + 24 * 60 * 60 * 1000

        return journalDao.hasEntryBetween(startTime, endTime)
    }
}
