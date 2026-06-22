package com.udacity.zenflow.di

import android.content.Context
import com.udacity.zenflow.data.JournalDao
import com.udacity.zenflow.data.JournalRepository
import com.udacity.zenflow.data.RoomJournalRepository
import com.udacity.zenflow.data.ZenFlowDatabase
import com.udacity.zenflow.util.SystemTimeProvider
import com.udacity.zenflow.util.TimeProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindTimeProvider(
        impl: SystemTimeProvider
    ): TimeProvider

    // TODO: This connects your Interface (JournalRepository) to your Implementation (RoomJournalRepository).
    @Binds
    @Singleton
    abstract fun bindJournalRepository(
        impl: RoomJournalRepository
    ): JournalRepository

    companion object {

        // TODO: Instantiate the Room Database.
        // 1. Use Room.databaseBuilder.
        // 2. Decide on a database name.
        // 3. For development, you might want to allow destructive migration to avoid crashes on schema changes.
        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext context: Context): ZenFlowDatabase {
            TODO("Not yet implemented")
        }

        // TODO: Provide the JournalDao dependency.
        // Hint: You don't create DAOs directly; you ask the database instance for them.
        @Provides
        fun provideJournalDao(database: ZenFlowDatabase): JournalDao {
            TODO("Not yet implemented")
        }
    }
}