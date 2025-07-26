package com.mavericks.mitumbaesales
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.mavericks.mitumbaesales.screens.HomeScreen
import com.mavericks.miumbaseales.ui.themes.AppTheme
import com.mavericks.mitumbaesales.screens.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "sign_up_route"
                    ) {
                        composable("sign_up_route") {
                            SignUpScreen(
                                onLoginClick = { navController.navigate("sign_in_route") },
                                onSignUpSuccess = {
                                    navController.navigate("home_route") {
                                        popUpTo("sign_up_route") { inclusive = true }
                                    }
                                }
                            )
                        }

                        composable("sign_in_route") {
                            NewSignInScreen(
                                onForgotPasswordClick = {
                                    navController.navigate("forgot_password_route")
                                },
                                onSignUpClick = {
                                    navController.navigate("sign_up_route")
                                },
                                onLoginSuccess = {
                                    navController.navigate("home_route") {
                                        popUpTo("sign_in_route") { inclusive = true }
                                    }
                                }
                            )
                        }
                        composable("forgot_password_route") {
                            ForgotPasswordScreen(
                                onBackToLoginClicked = {
                                    navController.popBackStack()
                                }
                            )
                        }
                        composable("home_route") {
                            HomeScreen(
                                username = "Marion!",
                                onCategoryClick = { },
                                onProductClick = { },
                                bottomNavSelected = 0,
                                onBottomNavClick = { }
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
    AppTheme {
        HomeScreen(
            username = "Marion!",
            onCategoryClick = {},
            onProductClick = {},
            bottomNavSelected = 0,
            onBottomNavClick = {}
        )
    }
}
