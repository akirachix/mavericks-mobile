package com.mavericks.mitumbaesales

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "reset_password"
    ) {
        composable("reset_password") {
            ResetPasswordScreen(
                onBackClicked = { navController.popBackStack() },
                onContinueClicked = { navController.navigate("confirmation") }
            )
        }
        composable("confirmation") {
            SuccessScreen()
        }
    }
}
