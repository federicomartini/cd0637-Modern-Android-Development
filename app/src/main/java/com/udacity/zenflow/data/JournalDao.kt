package com.udacity.zenflow.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalDao {
    @Query("SELECT * FROM journal_entries ORDER BY timestamp DESC")
    fun getAllEntries(): Flow<List<JournalEntry>>

    @Insert
    suspend fun insertEntry(entry: JournalEntry)

    @Query("SELECT EXISTS(SELECT 1 FROM journal_entries WHERE timestamp >= :startTime AND timestamp < :endTime)")
    suspend fun hasEntryBetween(startTime: Long, endTime: Long): Boolean
}