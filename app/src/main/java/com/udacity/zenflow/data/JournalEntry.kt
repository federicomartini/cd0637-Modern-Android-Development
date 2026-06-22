package com.udacity.zenflow.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// TODO: You may evolve this schema as your feature set grows.
// Feel free to expand and add more features!
// Consider: additional fields (mood/tags), indexing, constraints, or normalization.
@Entity(tableName = "journal_entries")
data class JournalEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    // TODO: Decide what "content" should represent (plain text, markdown, etc.)
    val content: String,

    // TODO: Decide how you want to represent time (UTC vs local, source of truth, etc.)
    val timestamp: Long = System.currentTimeMillis()
)
