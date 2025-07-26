
package com.mavericks.miumbaseales.ui.themes
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mavericks.mitumbaesales.R
import com.mavericks.mitumbaesales.ui.theme.Beige
import com.mavericks.mitumbaesales.ui.theme.Gold
import com.mavericks.mitumbaesales.ui.theme.NavyBlue
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.SideEffect

import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.mavericks.mitumbaesales.ui.theme.GoldenrodYellow
import com.mavericks.mitumbaesales.ui.theme.LightYellow
import com.mavericks.mitumbaesales.ui.theme.White


val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_light, FontWeight.Light)
)


private val DarkColorScheme = darkColorScheme(
    primary = NavyBlue,
    onPrimary = White,
    secondary = GoldenrodYellow,
    onSecondary = White,
    surface = Color(0xFF1C1B1F),
    onSurface = Color(0xFFE6E1E5),
    background = Color(0xFF1C1B1F),
    onBackground = Color(0xFFE6E1E5),
    surfaceVariant = NavyBlue,
    onSurfaceVariant = White
)

val AppTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        color = NavyBlue
    ),
    bodyMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = NavyBlue
    ),
    labelSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        color = Gold
    )
)


private val LightColorScheme = lightColorScheme(
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

@Composable
fun MitumbaesalesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),

    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}


@Composable
fun AppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = AppTypography,
        content = content
    )
}
