# ZenFlow - Advanced Android Architecture Project

## 🎯 Mission
Welcome to the ZenFlow project! You have been hired to finish building a mindfulness application. 
The UI design team has provided the assets, and the System Architect has laid out the structure (Hilt, Room, MVVM),
but the **core logic** and **implementation details** are missing.

Your goal is to make this app functional, robust, and creative.

## 🛠 Tech Stack
* **Kotlin**
* **Jetpack Compose** (UI)
* **Room** (Local Database)
* **Hilt** (Dependency Injection)
* **WorkManager** (Background Tasks)
* **Coroutines & Flow**

## 📝 Requirements

### 1. Data Layer (Room & SQL)
* **File:** `data/JournalDao.kt`
    * Write the SQL query to retrieve all journal entries.
    * Write the SQL query to check if an entry exists between two timestamps (`hasEntryBetween`).
* **File:** `data/RoomJournalRepository.kt`
    * Implement `hasEntryForToday()`: Calculate the start/end timestamps for the current day and query the DAO.
    * Implement `addEntry()` and `getAllEntries()`.

### 2. Dependency Injection
* **File:** `di/AppModule.kt`
    * Provide the `ZenFlowDatabase` instance using `Room.databaseBuilder`.
    * Provide the `JournalDao` instance.

### 3. UI Layer (Jetpack Compose)
* **File:** `ui/home/HomeScreen.kt`
    * Design a dashboard. It must show a greeting, the date, and navigation buttons.
    * *Challenge:* Make the greeting dynamic based on the time of day.
* **File:** `ui/breathing/BreathingScreen.kt`
    * Create a custom animation that expands (Inhale), holds, and shrinks (Exhale).
    * Use `animateFloatAsState` or similar APIs.
* **File:** `ui/journal/JournalScreen.kt`
    * Build an Input area (TextField + Button) and a List area (LazyColumn) to display database entries.
    * Connect the UI to the `JournalViewModel`.

### 4. Background Work & Notifications
* **File:** `worker/ReminderWorker.kt`
    * Implement logic to check if the user has journaled today.
    * If not, trigger a Notification.
    * *Note:* Handle Android O+ Notification Channels.
* **File:** `ZenFlowApp.kt`
    * Schedule the `ReminderWorker` to run periodically (e.g., every 24 hours).
* **File:** `AndroidManifest.xml` & `MainActivity.kt`
    * Add the `POST_NOTIFICATIONS` permission.
    * Request runtime permissions in `MainActivity` for Android 13+.

## 🚀 Getting Started
1.  Clone the repo.
2.  Open in Android Studio.
3.  Sync Gradle (Hilt might complain until you fix `AppModule.kt`).
4.  Search for `// TODO` in the project view to find your tasks.

Good luck!