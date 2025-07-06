package com.mavericks.mitumbaesales
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mavericks.mitumbaesales.screens.ForgotPasswordScreen
import com.mavericks.mitumbaesales.screens.NewSignInScreen
import com.mavericks.mitumbaesales.ui.theme.MitumbaesalesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MitumbaesalesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "sign_in_route"
                    ) {
                        composable("sign_in_route") {
                            NewSignInScreen(
                                onForgotPasswordClick = { navController.navigate("forgot_password_route") },
                                onSignUpClick = {  }
                            )
                        }
                        composable("forgot_password_route") {
                            ForgotPasswordScreen(
                                onBackToLoginClicked = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MitumbaesalesTheme {
        NewSignInScreen(onForgotPasswordClick = {}, onSignUpClick = {})
    }
}
