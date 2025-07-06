package com.mavericks.mitumbaesales


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SuccessScreen() {
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_bold)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            Spacer(modifier = Modifier.height(200.dp))


            Image(
                painter = painterResource(id = R.drawable.ic_shield_check),
                contentDescription = "Custom Shield Icon",
                modifier = Modifier.size(140.dp)
            )


            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Password changed successfully!",
                color = Color(0xFF0B3D91),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFontFamily,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Your password has been changed successfully, we will let you know if there are more problems with your account",
                color = Color.Black,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0B3D91))
            ) {
                Text(
                    text = "Continue",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily,
                    fontSize = 24.sp
                )
            }
            Spacer(modifier = Modifier.height(160.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSuccessScreen() {
    SuccessScreen()
}
