package com.mavericks.mitumbaesales

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun JoinMitumbaScreen(
    onSignUpClicked:()-> Unit,
    onLoginClicked: ()-> Unit
) {
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_bold)
    )
    Spacer(modifier = Modifier.height(25.dp))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Ready to join Kenya's mitumba revolution?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppinsFontFamily,
            color = Color(0xFF0b3d91),
            textAlign = TextAlign.Center,
            lineHeight = 36.sp

        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Start buying today, right from \n your phone.",
            fontSize = 20.sp,
            color = Color.Black,
            fontFamily = poppinsFontFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(2.dp))
        Image(
            painter = painterResource(id = R.drawable.store_img),
            contentDescription = "Store-image",
            modifier = Modifier
                .size(380.dp)
        )

        Button(
            onClick = {onSignUpClicked() },
            modifier = Modifier
                .width(330.dp)
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),

            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color(0xFFdaa520),
                contentColor = Color.White
            )

        ) {
            androidx.compose.material3.Text(
                text = "Sign Up",
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFontFamily,
                fontSize = 24.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {onLoginClicked() },
            modifier = Modifier
                .width(330.dp)
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(2.dp, Color(0xFF0b3d91)),

                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Transparent,
                contentColor = Color.Black
            )

        ) {
            androidx.compose.material3.Text(
                text = "Login",
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFontFamily,
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewJoinMitumbaScreen() {
    JoinMitumbaScreen(
        onSignUpClicked = {},
        onLoginClicked = {}

    )
}