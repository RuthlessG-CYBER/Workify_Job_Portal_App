package com.example.workifyjobportal

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun JobPortalUI(navController: NavController) {
    val pages = listOf(
        OnboardingPage("Find your", "Dream Job", R.drawable.background),
        OnboardingPage("Get Hired", "In Top Companies", R.drawable.background_2),
        OnboardingPage("Build Your", "Career Path", R.drawable.background_3)
    )

    var currentPage by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image with Crossfade
        Crossfade(targetState = pages[currentPage].imageRes, label = "") { imageRes ->
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize().padding(bottom = 70.dp)
            )
        }

        // Top "Skip" button
        Column(modifier = Modifier.fillMaxSize().padding(top = 35.dp)) {
            Row(
                modifier = Modifier
                    .height(30.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (currentPage < pages.lastIndex) {
                    Text(
                        text = "Skip",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable { currentPage++ }
                    )
                    Icon(
                        Icons.Default.ArrowForwardIos,
                        contentDescription = "Skip",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(100.dp))

            // Center title
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                AnimatedContent(targetState = currentPage, label = "") { page ->
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = pages[page].title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Text(
                            text = pages[page].subtitle,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 20.dp)
                        )
                    }
                }

            }
        }

        // Bottom Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF458665).copy(alpha = 0.9f)
            ),
            shape = RoundedCornerShape(0.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Find jobs that match your passion",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                    Text(
                        text = "Here, update daily, and apply easily.",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    Row(
                        modifier = Modifier.padding(horizontal = 30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (currentPage == pages.lastIndex) {
                            TextButton(
                                onClick = { navController.navigate("login") },
                                modifier = Modifier.width(150.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF156f3a).copy(alpha = 0.9f),
                                ),
                                shape = RoundedCornerShape(15.dp)
                            ) {
                                Text(text = "Get Started", color = Color.White)
                            }
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        PageIndicator(currentPage = currentPage, totalPages = pages.size)
                    }
                }
            }
        }
    }
}

data class OnboardingPage(
    val title: String,
    val subtitle: String,
    val imageRes: Int
)

@Composable
fun PageIndicator(currentPage: Int, totalPages: Int) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(16.dp)
    ) {
        repeat(totalPages) { index ->
            if (index == currentPage) {
                // Active (elongated)
                Box(
                    modifier = Modifier
                        .width(24.dp)
                        .height(8.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.White)
                )
            } else {
                // Inactive (dot)
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.6f))
                )
            }
        }
    }
}
