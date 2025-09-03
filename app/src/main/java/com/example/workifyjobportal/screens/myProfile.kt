package com.example.workifyjobportal.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun myProfile(navController: NavController){
    Box(modifier = Modifier.fillMaxSize())
    {
        // Header Section
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth().height(100.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxSize())
                {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(90.dp)
                                .background(Color.Gray, shape = CircleShape)
                        )

                        Spacer(modifier = Modifier.width(30.dp))

                        Box {
                            Column {
                                Text(
                                    text = "John Doe",
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Software Engineer",
                                    fontSize = 16.sp,
                                    color = Color.Black
                                )
                                Row {
                                    Icon(
                                        Icons.Default.Call,
                                        contentDescription = "Contact Icon",
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(text = "+91-8659542945", fontSize = 13.sp)
                                }
                                Row {
                                    Icon(
                                        Icons.Default.Email,
                                        contentDescription = "Email Icon",
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(5.dp))
                                    Text(text = "pandasoumya605@gmail.com", fontSize = 13.sp)
                                }
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                OutlinedButton(onClick = { /* Handle Edit Profile */ }, modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Edit Profile",
                        fontSize = 12.sp
                    )

                }
                Spacer(modifier = Modifier.width(10.dp))

                val context = LocalContext.current
                val downloadUrl = "https://drive.google.com/uc?export=download&id=1AbCdEfGhIJklMnOpQRsTuvWxYz"

                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(downloadUrl))
                        context.startActivity(intent)
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Download, contentDescription = "Download Icon", modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Download Resume", fontSize = 12.sp)
                }
            }
            Divider()
            // Content Section
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth().background(
                        color,
                        shape = RoundedCornerShape(10.dp)
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column(modifier = Modifier.padding(15.dp)) {
                        Text(text = "About Me", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                            color = Color.White)
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Passionate software engineer with 5 years of experience in mobile and web development. Skilled in Kotlin, Java, and JavaScript. Adept at problem-solving and delivering high-quality solutions.",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                }

                // Skills Section
                Card(
                    modifier = Modifier.fillMaxWidth()
                        .background(color,
                            shape = RoundedCornerShape(10.dp)),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                    Column {
                        Text(
                            text = "Skills",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 15.dp, top = 15.dp),
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            val skills = listOf(
                                "Kotlin",
                                "Java",
                                "JavaScript",
                                "React",
                                "Node.js",
                                "SQL",
                                "Git"
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            skills.forEach { skill ->

                                AssistChip(
                                    onClick = { /* Handle skill click */ },
                                    label = { Text(skill) },
                                    modifier = Modifier.padding(bottom = 10.dp),
                                    colors = androidx.compose.material3.AssistChipDefaults.assistChipColors(
                                        containerColor = Color(0xFFE0DADA),
                                        labelColor = Color.Black
                                    )
                                )

                            }
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                }

                // Contact Information Section
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEBE8E8)),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Column {
                        Text(
                            text = "Projects",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 10.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier.padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                        ) {
                            val projects = listOf(
                                "Project 1 - E-commerce App (Stylish App)",
                                "Project 2 - Finance Tracker App",
                                "Project 3 - Music Player App (Aura Player)",
                            )
                            projects.forEach { project ->
                                Text(
                                    text = project,
                                    fontSize = 15.sp,
                                    textDecoration = TextDecoration.Underline,
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Medium
                                    )
                            }
                        }
                    }
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFEBE8E8)),
                    shape = RoundedCornerShape(10.dp)
                ){
                    Column {
                        Text(
                            text = "Certifications",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 15.dp, top = 15.dp, bottom = 10.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(5.dp),
                            modifier = Modifier.padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
                        ) {
                            val certifications = listOf(
                                "Certified Kotlin Developer - Udemy",
                                "Artificial Intelligence - SVU",
                                "Python Programming - IUCEE",
                            )
                            certifications.forEach { cert ->
                                Text(
                                    text = cert,
                                    fontSize = 15.sp,
                                    textDecoration = TextDecoration.Underline,
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                }
            }

        }
    }
}

var color = Brush.linearGradient(
    colors = listOf(
        Color(0xFF656D70),
        Color(0xFF332C2C)
    )
)