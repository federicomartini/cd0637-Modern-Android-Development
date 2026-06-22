package com.udacity.zenflow.data

import kotlinx.coroutines.flow.Flow

/**
 * Interface defining the contract for data operations.
 *
 * TODO: Feel free to modify this contract if your architectural pattern requires it.
 */
interface JournalRepository {

    fun getAllEntries(): Flow<List<JournalEntry>>

    suspend fun addEntry(content: String)

    // TODO: Write the logic to check if there is an entry for the day in this method.
    suspend fun hasEntryForToday(): Boolean
}