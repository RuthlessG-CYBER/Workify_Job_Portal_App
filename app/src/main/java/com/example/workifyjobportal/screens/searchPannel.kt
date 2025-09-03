package com.example.workifyjobportal.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun searchPannel(navController: NavController){

    Box(modifier = Modifier
        .fillMaxWidth()
        .systemBarsPadding()
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 20.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            var searchQuery by remember { mutableStateOf("") }
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text(text = "Search") },
                modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
                shape = RoundedCornerShape(10.dp),
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Icon"
                    )
                }
            )

            Spacer(modifier = Modifier.width(10.dp))

            Card(modifier = Modifier.size(55.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Gray
                )
                ){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Icon",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}