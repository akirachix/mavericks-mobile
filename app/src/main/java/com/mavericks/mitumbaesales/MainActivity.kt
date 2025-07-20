package com.mavericks.mitumbaesales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mavericks.miumbaseales.ui.themes.MitumbaesalesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MitumbaesalesTheme {
               AppNavGraph()
            }

        }
    }
}

