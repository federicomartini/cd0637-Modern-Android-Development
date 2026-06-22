package com.udacity.zenflow.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

// TODO: Design the Navigation Graph for the App.
// Requirements:
// 1. A Bottom Navigation Bar that persists across screens.
// 2. Three main destinations: Home, Breathing, Journal.
// 3. The Home Screen acts as a dashboard and must be able to navigate to the other two.

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Hint: You might need to observe the current back stack entry to highlight
    // the correct bottom navigation item.
    // val navBackStackEntry by ...
    // val currentRoute = ...

    Scaffold(
        bottomBar = {
            // TODO: Implement the NavigationBar.
            // Add items for Home, Breathing, and Journal.
            // On click, navigate to the respective route.
            // Handle the "selected" state correctly.
        }
    ) { innerPadding ->
        // TODO: Setup the NavHost.
        // pass 'innerPadding' to the content to avoid UI overlap.

        // NavHost(navController = navController, startDestination = "home", ...) {

        // 1. Define the Home composable.
        //    REMINDER: The HomeScreen requires two callbacks:
        //    onNavigateToBreathing = { ... }
        //    onNavigateToJournal = { ... }

        // 2. Define the Breathing composable.
        //    (Don't forget to wrap it in a viewModel() or hiltViewModel() provider if needed).

        // 3. Define the Journal composable.
        // }
    }
}