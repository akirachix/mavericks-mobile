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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle





val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semibold, FontWeight.SemiBold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_thin, FontWeight.Thin)
)








@Composable
fun SignUpScreen() {


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
                    // Adjusted end offset for a more vertical gradient fill effect
                    end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
    ) {
        // White rounded card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.92f) // Consider making this more dynamic if content can vary
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
                    fontFamily = poppinsFontFamily,
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
                    shape = RoundedCornerShape(20.dp), // Consider using MaterialTheme.shapes for consistency
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                ) {
                    Text(
                        "Sign Up",
                        fontFamily = poppinsFontFamily,
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
                    // .padding(start = 4.dp) // Checkbox has its own internal padding
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color(0xFF01305D),
                            uncheckedColor = Color.Black, // Consider a less stark color for unchecked
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
                        fontFamily = poppinsFontFamily,
                        fontSize = 14.sp,
                        // Add a default color for the text that is not styled
                        color = Color.Black.copy(alpha = 0.7f) // Example: slightly dimmed black
                    )
                }




                Spacer(modifier = Modifier.height(18.dp))








                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Have an account? ",
                        fontFamily = poppinsFontFamily,
                        fontSize = 16.sp,
                        color = Color(0xFF171717),
                    )
                    Text(
                        "Login",
                        fontFamily = poppinsFontFamily,
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
    // The outer Box for background and border seems fine.
    // The main change is within the TextField call.
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp) // Height is often controlled by TextField's internal padding & text style
            .border(
                BorderStroke(1.dp, Color(0xFFE0DFB6)),
                shape = RoundedCornerShape(16.dp)
            ),
        textStyle = TextStyle(
            fontFamily = poppinsFontFamily,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        ),
        placeholder = {
            Text(
                fontFamily = poppinsFontFamily,
                text = placeholder,
                color = Color(0xFF707070),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        },
        leadingIcon = { // Use leadingIcon for the icon inside the TextField
            Icon(
                imageVector = icon,
                contentDescription = null, // Provide a meaningful description if needed
                tint = Color(0xFF707070),
                modifier = Modifier.size(28.dp)
            )
        },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true, // Common for input fields like these
        shape = RoundedCornerShape(16.dp), // Apply shape to TextField as well
        colors = TextFieldDefaults.colors( // Use M3 TextFieldDefaults.colors
            focusedContainerColor = Color(0xFFF9F8E4),
            unfocusedContainerColor = Color(0xFFF9F8E4),
            disabledContainerColor = Color(0xFFF9F8E4),
            focusedIndicatorColor = Color.Transparent, // Hides the underline indicator
            unfocusedIndicatorColor = Color.Transparent, // Hides the underline indicator
            disabledIndicatorColor = Color.Transparent, // Hides the underline indicator
            cursorColor = Color(0xFF01305D), // Example cursor color
            // You can also customize text color, placeholder color, etc. here if needed
            // but your textStyle and placeholder composable already handle some of this.
        )
    )
}




@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen(){


    SignUpScreen()


}

