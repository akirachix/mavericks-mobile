package com.mavericks.mitumbaesales

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmailPhoneVerificationScreen(
    onBackClicked: () -> Unit = {},
    onVerifyClicked: (String) -> Unit = {},
    onResendClicked: () -> Unit = {}
) {
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_bold)
    )
    var code by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            val width = size.width
            val height = size.height


            val path = Path().apply {
                moveTo(0f, 0f)
                lineTo(0f, height * 0.65f)
                cubicTo(
                    width * 0.25f, height * 1.1f,
                    width * 0.75f, height * 0.15f,
                    width, height * 0.55f
                )
                lineTo(width, 0f)
                close()
            }
            drawPath(
                path = path,
                color = Color(0xFF0b3d91),
                style = Fill
            )

        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(36.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = onBackClicked,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Color.Transparent)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_arrow_back_24),
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Email/Phone Verification",
                    fontFamily = poppinsFontFamily,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 23.sp
                )
            }

            Spacer(modifier = Modifier.height(240.dp))

            Text(
                text = "Get Your Code",
                color = Color(0xFF0b3d91),
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFontFamily,
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(35.dp))

            Text(
                text = "Please enter the 4 digit code that was sent to your email/phone address.",
                color = Color(0xFF333333),
                fontSize = 16.sp,
                fontFamily = poppinsFontFamily,
                modifier = Modifier.padding(horizontal = 8.dp),
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (i in 0 until 4) {
                    OutlinedTextField(
                        value = code.getOrNull(i)?.toString() ?: "",
                        onValueChange = {
                            if (it.length == 1 && it[0].isDigit() && code.length < 4) {
                                code += it
                            }
                            if (it.isEmpty() && code.isNotEmpty()) {
                                code = code.dropLast(1)
                            }
                        },
                        modifier = Modifier
                            .width(60.dp)
                            .height(50.dp)
                            .padding(horizontal = 10.dp)
                            .background(Color(0xFFF5F5DC), RoundedCornerShape(10.dp)),
                        textStyle = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            fontFamily = poppinsFontFamily,
                            textAlign = TextAlign.Center
                        ),

                        placeholder = { Text("") }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "If you don’t get code",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = poppinsFontFamily
                )
                Spacer(modifier = Modifier.width(4.dp))
                TextButton(
                    onClick = onResendClicked,
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(
                        text = "Resend",
                        color = Color(0xFFDAA520),
                        fontWeight = FontWeight.Bold,
                        fontFamily = poppinsFontFamily,
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(90.dp))

            Button(
                onClick = {
                    if (code.length == 4) {
                        errorMessage = ""
                        onVerifyClicked(code)
                    } else {
                        errorMessage = "Enter the 4 digit code!"
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0b3d91),
                contentColor = Color.White
            )

            ) {
                Text(
                    text = "Verify and Proceed",
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily,
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEmailPhoneVerificationScreen() {
    MaterialTheme {
        EmailPhoneVerificationScreen(
            onBackClicked = {},
            onVerifyClicked = {},
            onResendClicked = {}
        )
    }
}
