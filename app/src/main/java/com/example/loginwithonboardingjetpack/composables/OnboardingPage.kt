@file:Suppress("SpellCheckingInspection")

package com.example.loginwithonboardingjetpack.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.loginwithonboardingjetpack.R
import com.example.loginwithonboardingjetpack.ui.theme.purplish

@Composable
fun OnboardingPage(navController: NavHostController) {
    Box {
        BgCard2(navController)
        MainCard2()
    }
}

@Composable
fun BgCard2(navController: NavHostController) {
    Surface(color = purplish, modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                TextButton(onClick = {}) {
                    Text(text = "Skip", color = Color.White)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(onClick = {
                        navController.navigate(Screen.LoginPage.route)
                    }) {
                        Text(text = "Next", color = Color.White)
                        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_next),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun MainCard2() {
    Surface(
        color = Color.White, modifier = Modifier
            .height(500.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(60.dp).copy(topStart = ZeroCornerSize, topEnd = ZeroCornerSize)
    ) {
        Column(
            modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.ic_cleaning), contentDescription = null)
            Spacer(modifier = Modifier.padding(32.dp))
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                Text(text = "Cleaning on Demand", style = MaterialTheme.typography.h6)
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = "Book an appointment in less than 60 seconds and get on the schedule as early as tomorrow",
                    style = MaterialTheme.typography.caption, textAlign = TextAlign.Center
                )
            }
        }
    }
}

