package com.example.workifyjobportal.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun jobApplied(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ){
            Text(
                text = "My Jobs",
                modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState()).padding(start = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp) // spacing between items
            ) {
                var clicked by remember { mutableStateOf(-1) }
                val myJobLists = listOf("Saved", "Applied", "Interviewing", "Offered", "Archived")

                myJobLists.forEachIndexed { index, item ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { clicked = index }
                    ) {
                        Text(
                            text = "0",
                            fontSize = 15.sp,
                            textDecoration = if (clicked == index) TextDecoration.Underline else TextDecoration.None,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = item,
                            fontSize = 15.sp
                        )
                        if (clicked == index) {
                            Box(
                                modifier = Modifier
                                    .height(5.dp)
                                    .width(40.dp)
                                    .background(
                                        Color.Blue,
                                        shape = RoundedCornerShape(bottomStart = 3.dp, bottomEnd = 3.dp)
                                    )
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Divider(
                thickness = 1.dp,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = com.example.workifyjobportal.R.drawable.background_2),
                    contentDescription = "No Jobs",
                    modifier = Modifier
                        .size(180.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "No jobs found",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "You have not applied to any jobs yet. Start exploring and find your dream job today!",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 40.dp),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = {
                        navController.navigate("home")
                    },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth(0.4f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2D7D4A),
                        contentColor = Color.White
                    )
                ) {
                   Row(
                          verticalAlignment = Alignment.CenterVertically
                   ){
                       Text(text = "Find Jobs", fontSize = 16.sp)
                          Spacer(modifier = Modifier.width(10.dp))
                       Icon(
                           Icons.Default.ArrowForward,
                            contentDescription = "Find Jobs",
                            modifier = Modifier.size(20.dp)
                       )
                   }
                }
            }

        }
    }
}
