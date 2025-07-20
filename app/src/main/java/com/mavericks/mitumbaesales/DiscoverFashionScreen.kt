package com.mavericks.mitumbaesales

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun WelcomeScreen(
    onGetStartedClicked:()->Unit
) {
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_bold)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0b3d91))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFdaa520), Color(0xFFdaa520))
                    )
                ),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(80.dp))

                Text(
                    text = "Welcome to Mitumba e-sales",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 30.sp,
                    fontFamily = poppinsFontFamily

                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Buy stylish second-hand fashion.Sell faster and reach more customer.",
                    color = Color(0xFF0b3d91),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = poppinsFontFamily
                )
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.welcome_img),
                contentDescription = "People shopping for clothes",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 100.dp)
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .offset(y = (-80).dp)
                .background(Color(0xFF0b3d91))
                .padding(vertical = 30.dp, horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        )

        {
            Button(
                onClick = {onGetStartedClicked() },
                modifier = Modifier
                    .width(310.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFdaa520)),
                shape = RoundedCornerShape(0.dp)
            ) {
                Text(
                    text = "Get Started",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMitumbaESalesScreen() {
    WelcomeScreen(
        onGetStartedClicked = { }
    )
}

