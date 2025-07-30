package com.example.workifyjobportal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.workifyjobportal.Data.CustomSliderElement
import com.example.workifyjobportal.Data.JobListing
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun JobUI(data: List<CustomSliderElement>, jobs: List<JobListing>){
    Box(modifier = Modifier.fillMaxSize())
    {
        Column(modifier = Modifier.fillMaxSize().padding(top = 10.dp))
        {
            //Top App Bar
            Card(modifier = Modifier.height(70.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ))
            {
                Row(
                    modifier = Modifier.fillMaxSize().padding(start = 20.dp, end = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = "Location",
                        modifier = Modifier.size(30.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = "Choose Location",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Row {
                            Text(
                                text = "Bengaluru, ",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Medium,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "India",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.sp
                            )
                            Icon(
                                Icons.Default.KeyboardArrowDown,
                                contentDescription = "Down Arrow",
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        )
                    ){
                        Icon(
                            painter = painterResource(R.drawable.logo_1),
                            contentDescription = "Person",
                            modifier = Modifier.size(50.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            val pagerState = rememberPagerState()
            val pageCount = data.size

            // Auto-scroll logic
            LaunchedEffect(Unit) {
                while (true) {
                    delay(3000)
                    val nextPage = (pagerState.currentPage + 1) % pageCount
                    pagerState.animateScrollToPage(nextPage)
                }
            }


            HorizontalPager(
                count = pageCount,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) { page ->
                CustomSlider(data[page])
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Search Bar and Menu Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                var searchText by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    placeholder = { Text(text = "Search for jobs") },
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Card(
                    modifier = Modifier.size(45.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            painter = painterResource(R.drawable.menu),
                            contentDescription = "Menu",
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            // Recommended Jobs
            Row {
                Text(
                    text = "Recommended Jobs",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 25.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "View All",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Blue,
                    modifier = Modifier.padding(end = 25.dp),
                    textDecoration = TextDecoration.Underline
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            val randomJobs = remember { jobs.shuffled().take(3) }

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(randomJobs) { job ->
                    JobCard(job = job)
                }
            }


        }
    }
}



@Composable
fun CustomSlider(item: CustomSliderElement){ item
    ElevatedCard(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ){
        Box(modifier = Modifier.fillMaxSize()){
           Row(modifier = Modifier.fillMaxSize().padding(top = 20.dp, bottom = 20.dp)){
               Column(
                   modifier = Modifier
               ){
                   Text(
                       text = item.title1,
                       fontSize = 20.sp,
                       color = Color.White,
                       modifier = Modifier.padding(start = 20.dp),
                       fontWeight = FontWeight.Bold
                   )
                   Text(
                       text = item.title2,
                       fontSize = 20.sp,
                       color = Color.White,
                       modifier = Modifier.padding(start = 20.dp),
                       fontWeight = FontWeight.Bold
                   )
                   Spacer(modifier = Modifier.weight(1f))
                   Text(
                       text = item.subtitle1,
                       fontSize = 10.sp,
                       color = Color.White,
                       modifier = Modifier.padding(start = 20.dp),
                       fontWeight = FontWeight.Medium
                   )
                   Text(
                       text = item.subtitle2,
                       fontSize = 10.sp,
                       color = Color.White,
                       modifier = Modifier.padding(start = 20.dp),
                       fontWeight = FontWeight.Normal
                   )
               }
               Spacer(modifier = Modifier.weight(1f))
               Image(
                   painter = painterResource(id = item.image),
                   contentDescription = "Background",
                   modifier = Modifier.size(200.dp)
               )
           }
        }
    }
}

@Composable
fun JobCard(job: JobListing) {
    Card(
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Company Logo
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFF3F4F6)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = job.logoResId),
                    contentDescription = "${job.company} Logo",
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = job.role,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = job.company,
                    color = Color.DarkGray,
                    fontSize = 13.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = job.location,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = job.salaryRange,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF111827)
                )

                Box(
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .background(
                            color = if (job.isFreelance) Color(0xFFD8D0F9) else Color(0xFFD5EAFE),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = job.jobType,
                        color = if (job.isFreelance) Color(0xFF6A5ACD) else Color(0xFF4B79F1),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

