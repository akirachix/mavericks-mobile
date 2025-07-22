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
        startDestination = "welcome_screen"
    ) {
        composable("welcome_screen") {
            WelcomeScreen(
                onGetStartedClicked = { navController.navigate("fashion_screen") }
            )
        }
        composable("fashion_screen") {
            FashionScreen(
                onBackClicked = { navController.popBackStack() },
                onNextClicked = { navController.navigate("teaser_screen") }
            )
        }
        composable("teaser_screen") {
            JoinMitumbaScreen(
                onSignUpClicked = { navController.navigate("signup") },
                onLoginClicked = { navController.navigate("login") }
            )
        }
        composable("signup") {
            SignUpScreen(
                onClickSignUpButtom = { navController.navigate(" ") },
                onLoginClick =  { navController.navigate("login") },
            )
        }
        composable("login") {
            NewSignInScreen(
                onForgotPasswordClick = { navController.navigate("forgot_password") },
                onSignUpClick = { navController.navigate("signup") },
            )
        }
        composable("forgot_password") {
            ForgotPasswordScreen(
                onBackToLoginClicked = { navController.navigate("login") },
                onSubmitClicked = { navController.navigate("verification_screen") },
            )
        }
        composable("verification_screen") {
            EmailPhoneVerificationScreen(
                onBackClicked = { navController.navigate("forgot_password") },
                onVerifyClicked = { navController.navigate("reset_password") },
            )
        }
        composable("reset_password") {
            ResetPasswordScreen(
                onBackClicked = { navController.navigate("verification_screen") },
                onContinueClicked = { navController.navigate("success_screen") },
            )
        }
        composable("success_screen") {
            SuccessScreen(
                onContinueClicked = { navController.navigate("") },
            )
        }
    }
}
