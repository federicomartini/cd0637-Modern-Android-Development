package com.udacity.zenflow.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [JournalEntry::class], version = 1, exportSchema = false)
abstract class ZenFlowDatabase : RoomDatabase() {
    abstract fun journalDao(): JournalDao
}
