package com.udacity.zenflow.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(
    onNavigateToBreathing: () -> Unit,
    onNavigateToJournal: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // TODO: Build your Dashboard!
        // This is the first thing users see. Make it welcoming.

        // Requirements:
        // 1. Display a Greeting (e.g., "Welcome Back").
        //    (Challenge: Can you make it say "Good Morning" / "Good Evening" based on time?)

        // 2. Display the current Date formatted nicely.

        // 3. Create a primary "Call to Action" area (like a Card or Banner).
        //    Inside this area, provide buttons/links to:
        //      - Start a Breathing Session (calls onNavigateToBreathing)
        //      - Write in the Journal (calls onNavigateToJournal)

        // Feel free to use Column, Row, LazyColumn, or Scaffolds to structure this screen.
    }
}