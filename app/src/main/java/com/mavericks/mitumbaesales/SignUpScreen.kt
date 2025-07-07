package com.mavericks.mitumbaesales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SignUpScreen() {
    // State for text fields and checkbox
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF01305D), Color(0xFFDEB038)),
                    start = Offset(0f, 0f),
                    end = Offset(0f, 400f)
                )
            )
    ) {
        // White rounded card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.92f)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 18.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    "Sign Up",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Color(0xFF01305D),
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                // Name field
                InputField(
                    value = name,
                    onValueChange = { name = it },
                    icon = Icons.Default.Person,
                    placeholder = "Enter name"
                )
                Spacer(modifier = Modifier.height(16.dp))


                InputField(
                    value = email,
                    onValueChange = { email = it },
                    icon = Icons.Default.Email,
                    placeholder = "Email Address",
                    keyboardType = KeyboardType.Email
                )
                Spacer(modifier = Modifier.height(16.dp))


                InputField(
                    value = phone,
                    onValueChange = { phone = it },
                    icon = Icons.Default.Phone,
                    placeholder = "Phone Number",
                    keyboardType = KeyboardType.Phone
                )
                Spacer(modifier = Modifier.height(16.dp))


                InputField(
                    value = password,
                    onValueChange = { password = it },
                    icon = Icons.Default.Lock,
                    placeholder = "Password",
                    isPassword = true
                )
                Spacer(modifier = Modifier.height(16.dp))


                InputField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    icon = Icons.Default.Lock,
                    placeholder = "Confirm Password",
                    isPassword = true
                )
                Spacer(modifier = Modifier.height(24.dp))


                Button(
                    onClick = { /* handle sign up */ },
                    colors = ButtonDefaults.buttonColors(containerColor  = Color(0xFFDEB038)),
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    Text(
                        "Sign Up",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFF01305D),
                            uncheckedColor = Color.Black,
                            checkmarkColor = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        buildAnnotatedString {
                            append("By Sign up you agree to our ")
                            withStyle(style = SpanStyle(color = Color(0xFF01305D), fontWeight = FontWeight.Bold)) {
                                append("terms ")
                            }
                            append("and ")
                            withStyle(style = SpanStyle(color = Color(0xFFDEB038), fontWeight = FontWeight.Bold)) {
                                append("conditions")
                            }
                            append(".")
                        },
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))


                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Have an account? ",
                        fontSize = 16.sp,
                        color = Color(0xFF171717),
                    )
                    Text(
                        "Login",
                        fontSize = 16.sp,
                        color = Color(0xFF01305D),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable

fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    icon: ImageVector,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPassword: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFF9F8E4))
            .border(
                BorderStroke(1.dp, Color(0xFFE0DFB6)),
                shape = RoundedCornerShape(16.dp)
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 14.dp)
        ) {
            Icon(
                icon,
                contentDescription = null,
                tint = Color(0xFF707070),
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            TextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        text = placeholder,
                        color = Color(0xFF707070),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                },

                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                ),
                visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen(){
    SignUpScreen()

}
