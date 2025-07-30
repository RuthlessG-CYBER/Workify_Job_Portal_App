package com.example.workifyjobportal.Authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController){
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.padding(
                top = 100.dp,
                start = 20.dp,
                end = 20.dp,
                bottom = 20.dp
            )
        ){

            Text(
                text = "Welcome",
                fontSize = 35.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp)
            )
            Text(
                text = "to Workify",
                fontSize = 35.sp,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(start = 10.dp)
            )

            Spacer(modifier = Modifier.height(150.dp))

            var email by remember { mutableStateOf("") }
            Box(modifier = Modifier.fillMaxWidth()){
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    singleLine = true,
                    maxLines = 1,
                    shape = RoundedCornerShape(10.dp),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Email,
                            contentDescription = "Email Icon"
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            var password by rememberSaveable { mutableStateOf("") }
            var passwordVisible by remember { mutableStateOf(false) }
            Box(modifier = Modifier.fillMaxWidth()){
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Confirm Password") },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    singleLine = true,
                    maxLines = 1,
                    shape = RoundedCornerShape(10.dp),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(imageVector = icon, contentDescription = "Toggle Password")
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row {
                Text(
                    text = "Forgot Password?",
                    fontSize = 15.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 20.dp ,end = 20.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = {
                    if (email == "admin@123" && password == "123"){
                        navController.navigate("home")
                    }
                },
                    modifier = Modifier.padding(end = 20.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Log in",
                        fontSize = 15.sp,
                        letterSpacing = 2.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ){
                Text(
                    text = "Don't have an account?",
                    fontSize = 15.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                )
                Text(
                    text = "Sign up",
                    fontSize = 15.sp,
                    letterSpacing = 2.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp).clickable { navController.navigate("signup") },
                    textDecoration = TextDecoration.Underline
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = com.example.workifyjobportal.R.drawable.google),
                    contentDescription = "Page Background",
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(25.dp))

                Image(
                    painter = painterResource(id = com.example.workifyjobportal.R.drawable.facebook),
                    contentDescription = "Page Background",
                    modifier = Modifier.size(30.dp)
                )

                Spacer(modifier = Modifier.width(25.dp))

                Image(
                    painter = painterResource(id = com.example.workifyjobportal.R.drawable.x),
                    contentDescription = "Page Background",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}