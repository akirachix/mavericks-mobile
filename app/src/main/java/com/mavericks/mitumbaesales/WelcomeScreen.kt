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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.BorderStroke


@Composable
fun FashionScreen(
    onBackClicked:()->Unit,
    onNextClicked:()->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)

        ) {

            Image(
                painter = painterResource(id = R.drawable.welcome_img),
                contentDescription = "Stylish people enjoying fashion",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.weight(0.5f))

                Text(
                    text = "Discover Fashion Finds",
                    color = Color(0xFFdaa520),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 44.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Explore unique, Affordable \n second-hand styles",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Left,
                    fontFamily = poppinsFontFamily,
                    lineHeight = 26.sp
                )
                Spacer(modifier = Modifier.weight(0.3f))
            }
        }


        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 16.dp)
                .width(120.dp)
                .height(20.dp)
                .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                .background(Color.Black)

        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .align(Alignment.BottomCenter)
                .background(Color.White)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {onBackClicked() },
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
                    .padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color(0xFF000000))
            ) {
                Text(
                    text = "Back",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = com.mavericks.mitumbaesales.ui.theme.poppinsFontFamily
                )
            }

            Button(
                onClick = { onNextClicked()},
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
                    .padding(start = 8.dp),

                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFdaa520)),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text(
                    text = "Next",
                    color = Color.White,
                    fontFamily = com.mavericks.mitumbaesales.ui.theme.poppinsFontFamily,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUnifiedFashionScreen() {
    FashionScreen(
        onBackClicked = {},
        onNextClicked = {}
    )
}

