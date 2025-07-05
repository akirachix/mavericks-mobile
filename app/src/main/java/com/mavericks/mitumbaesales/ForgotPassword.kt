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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.TextUnit
import com.mavericks.mitumbaesales.R
import com.mavericks.mitumbaesales.poppinsFontFamily


@Composable
fun ForgotPasswordScreen(
    onBackToLoginClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var emailOrPhone by remember { mutableStateOf("") }

    val NavyBlue = Color(0xFF0B3D91)
    val LightYellow = Color(0xFFFFFBE6)
    val GoldenrodYellow = Color(0xFFDAA520) 


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {


        Card(
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            modifier = Modifier
                .fillMaxSize()
                .offset(y = 0.dp),
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
                    text = "Forgot\nPassword",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFontFamily,
                    color = NavyBlue,
                    lineHeight = 36.sp
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Enter your registered email/phone\naddress. We'll send you a code to reset\nyour password.",
                    fontSize = 14.sp,
                    fontFamily = poppinsFontFamily,
                    color = NavyBlue,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
                Spacer(modifier = Modifier.height(32.dp))

                // Email Address Field
                OutlinedTextField(
                    value = emailOrPhone,
                    onValueChange = { emailOrPhone = it },
                    label = {
                        Text(
                            "Email address",
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
                    value = "",
                    onValueChange = { },
                    label = {
                        Text(
                            "Phone number",
                            fontFamily = poppinsFontFamily,
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_phone),
                            contentDescription = "Phone icon",
                            tint = NavyBlue
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
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
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("Back to ")
                            withStyle(style = SpanStyle(color = GoldenrodYellow, fontWeight = FontWeight.SemiBold)) {
                                append("Login")
                            }
                        },
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                        modifier = Modifier.clickable { onBackToLoginClicked() }
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { /* Handle Submit */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = NavyBlue)
                ) {
                    Text(
                        "Submit",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = poppinsFontFamily
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForgotPasswordScreen() {
    ForgotPasswordScreen(onBackToLoginClicked = {})
}
