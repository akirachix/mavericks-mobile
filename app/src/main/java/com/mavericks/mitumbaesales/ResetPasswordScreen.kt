package com.mavericks.mitumbaesales


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.OutlinedTextField

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily



@Composable
fun ResetPasswordScreen(
    onBackClicked: () -> Unit = {},
    onContinueClicked: () -> Unit = {}
) {
    val poppinsFontFamily = FontFamily(
        Font(R.font.poppins_regular),
        Font(R.font.poppins_bold)
    )
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
                    text = "Reset password",
                    fontFamily = poppinsFontFamily,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            }


            Spacer(modifier = Modifier.height(190.dp))

            Text(
                text = "Enter new password",
                color = Color(0xFF0b3d91),
                fontWeight = FontWeight.Bold,
                fontFamily = poppinsFontFamily,
                fontSize = 24.sp
            )


            Spacer(modifier = Modifier.height(50.dp))


            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }
            var errorMessage by remember { mutableStateOf(" ") }


            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Password",
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Normal

                )
                Spacer(modifier = Modifier.height(4.dp))




                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5DC))
                        .border(1.dp, Color(0xFFDAA520), RoundedCornerShape(20.dp)),
                    placeholder = { Text("*************", color = Color(0xFF9B9B9B)) },
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = Color(0xFFF5F5DC),
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        textColor = Color.Black
                    ),
                    textStyle = TextStyle(fontSize = 12.sp),
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_lock),
                            contentDescription = "Lock",
                            tint = Color(0xFF9B9B9B),
                            modifier = Modifier.size(24.dp)
                        )

                    }
                )

                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Confirm Password",
                    color = Color.Black,
                    fontFamily = poppinsFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(6.dp))


                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5DC))
                        .border(1.dp, Color(0xFFDAA520), RoundedCornerShape(20.dp)),
                    placeholder = { Text("*************", color = Color(0xFF9B9B9B)) },
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = Color(0xFFF5F5DC),
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        disabledBorderColor = Color.Transparent,
                        errorBorderColor = Color.Transparent,
                        textColor = Color.Black
                    ),
                    textStyle = TextStyle(fontSize = 12.sp),
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_lock),
                            contentDescription = "Lock",
                            tint = Color(0xFF9B9B9B),
                            modifier = Modifier.size(24.dp)
                        )

                    }
                )
            }

            if (errorMessage.isNotEmpty()){
                Text(
                    text = errorMessage,
                    color=Color.Red,
                    fontSize = 16.sp,
                    fontFamily = poppinsFontFamily,
                    modifier = Modifier.padding(top = 8.dp)
                    )
            }

            Spacer(modifier = Modifier.height(78.dp))

            Button(
                onClick = {
                    if(password == confirmPassword && password.isNotBlank()){
                        errorMessage=""
                        onContinueClicked()
                    }
                    else{
                        errorMessage="Passwords do not match or are empty!"
                    }
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF0b3d91),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Continue",
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
fun PreviewResetPasswordScreen() {
    MaterialTheme {
        ResetPasswordScreen(
            onBackClicked = {},
            onContinueClicked = {}
        )
    }
}

