package com.mavericks.mitumbaesales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge 
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mavericks.mitumbaesales.screens.ForgotPasswordScreen
import com.mavericks.mitumbaesales.screens.NewSignInScreen
import com.mavericks.mitumbaesales.R



val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() 
        setContent {
        
           val NavyBlue = Color(0xFF0B3D91) 
            val LightYellow = Color(0xFFFFFBE6)
          val GoldenrodYellow = Color(0xFFDAA520) 
            val White = Color(0xFFFFFFFF)


            val AppLightColorScheme = lightColorScheme(
                primary = NavyBlue,
                onPrimary = White,
                secondary = GoldenrodYellow,
                onSecondary = White,
                surface = White,
                onSurface = NavyBlue,
                background = White,
                onBackground = NavyBlue,

                surfaceVariant = LightYellow,
                onSurfaceVariant = NavyBlue
            )


            MaterialTheme(colorScheme = AppLightColorScheme) {

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

    MaterialTheme(colorScheme = lightColorScheme()) {
        NewSignInScreen(onForgotPasswordClick = {}, onSignUpClick = {})
    }
}