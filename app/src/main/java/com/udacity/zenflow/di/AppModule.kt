package com.udacity.zenflow.di

import androidx.room.Room
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

    @Binds
    @Singleton
    abstract fun bindJournalRepository(
        impl: RoomJournalRepository
    ): JournalRepository

    companion object {

        @Provides
        @Singleton
        fun provideDatabase(@ApplicationContext context: Context): ZenFlowDatabase {
            return Room.databaseBuilder(
                context,
                ZenFlowDatabase::class.java,
                "zen_flow_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        @Provides
        fun provideJournalDao(database: ZenFlowDatabase): JournalDao {
            return database.journalDao()
        }
    }
}