package com.mavericks.mitumbaesales.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.TextUnit
import com.mavericks.mitumbaesales.R
import com.mavericks.mitumbaesales.poppinsFontFamily

@Composable
fun NewSignInScreen(
    onForgotPasswordClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val NavyBlue = Color(0xFF0B3D91) 
    val LightYellow = Color(0xFFFFFBE6)
    val GoldenrodYellow = Color(0xFFDAA520)


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(GoldenrodYellow, NavyBlue),
                        start = androidx.compose.ui.geometry.Offset(0f, 0f),
                        end = androidx.compose.ui.geometry.Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_background),
                contentDescription = "Top background image (person)",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .align(Alignment.BottomCenter)
            )
        }


        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-30).dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Shopping Bag Icon",
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Sign in",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily,
                    color = NavyBlue
                )
                Spacer(modifier = Modifier.height(32.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = {
                        Text(
                            "Email Address",
                            fontFamily = poppinsFontFamily,
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_email),
                            contentDescription = "Email icon",
                            tint = NavyBlue
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = LightYellow,
                        unfocusedContainerColor = LightYellow,
                        disabledContainerColor = LightYellow,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        focusedTextColor = NavyBlue,
                        unfocusedTextColor = NavyBlue,
                        focusedLabelColor = NavyBlue,
                        unfocusedLabelColor = NavyBlue
                    ),
                    textStyle = TextStyle(fontFamily = poppinsFontFamily, fontSize = 16.sp, color = NavyBlue)
                )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = {
                        Text(
                            "Enter Password",
                            fontFamily = poppinsFontFamily,
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_password),
                            contentDescription = "Lock icon",
                            tint = NavyBlue
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = LightYellow,
                        unfocusedContainerColor = LightYellow,
                        disabledContainerColor = LightYellow,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        focusedTextColor = NavyBlue,
                        unfocusedTextColor = NavyBlue,
                        focusedLabelColor = NavyBlue,
                        unfocusedLabelColor = NavyBlue
                    ),
                    textStyle = TextStyle(fontFamily = poppinsFontFamily, fontSize = 16.sp, color = NavyBlue)
                )
                Spacer(modifier = Modifier.height(8.dp))

                AlignRightText(
                    text = "Forget Password?",
                    color = NavyBlue,
                    fontSize = 12.sp,
                    onClick = onForgotPasswordClick
                )
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { /* Handle Login */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = NavyBlue)
                ) {
                    Text(
                        "Login",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = poppinsFontFamily
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(color = NavyBlue)) {
                                append("New around here? ")
                            }
                            withStyle(style = SpanStyle(color = GoldenrodYellow, fontWeight = FontWeight.SemiBold)) {
                                append("sign up")
                            }
                        },
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                        modifier = Modifier.clickable { onSignUpClick() }
                    )
                }
            }
        }
    }
}

@Composable
fun AlignRightText(
    text: String,
    color: Color,
    fontSize: TextUnit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = text,
            color = color,
            fontSize = fontSize,
            fontFamily = poppinsFontFamily,
            modifier = Modifier.clickable { onClick() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewSignInScreen() {
    NewSignInScreen(onForgotPasswordClick = {}, onSignUpClick = {})
}
