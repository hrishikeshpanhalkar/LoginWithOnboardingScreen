package com.example.loginwithonboardingjetpack.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginwithonboardingjetpack.R
import com.example.loginwithonboardingjetpack.ui.theme.purplish
import com.example.loginwithonboardingjetpack.ui.theme.organist
import com.example.loginwithonboardingjetpack.ui.theme.Shapes

@Preview(showBackground = true)
@Composable
fun LoginPage() {
    Box {
        BgCard()
        MainCard()
    }
}

@Composable
fun BgCard() {
    val signupText = buildAnnotatedString {
        append("Don't have an account? ")
        withStyle(SpanStyle(color = organist)) {
            append("Sign up here!")
        }
    }
    Surface(color = purplish, modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_fb),
                    contentDescription = null,
                    Modifier.padding(horizontal = 4.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = null,
                    Modifier.padding(horizontal = 4.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_twitter),
                    contentDescription = null,
                    Modifier.padding(horizontal = 4.dp)
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = signupText, color = Color.White, modifier = Modifier.padding(bottom = 10.dp))
        }
    }
}


@Composable
fun MainCard() {
    val emailState = remember { mutableStateOf(TextFieldValue("hrishi07@gmail.com")) }
    val passState = remember { mutableStateOf(TextFieldValue("")) }
    Surface(
        color = Color.White, modifier = Modifier
            .height(500.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(60.dp).copy(topStart = ZeroCornerSize, topEnd = ZeroCornerSize)
    ) {
        Column(
            modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
            Image(painter = painterResource(id = R.drawable.ic_vaccuum), contentDescription = null, Modifier.height(200.dp))
            Spacer(modifier = Modifier.padding(16.dp))
            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = {
                    Text(text = "Email Address")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Leading Icon") },
                modifier = modifier
            )
            Spacer(modifier = Modifier.padding(6.dp))
            OutlinedTextField(
                value = passState.value,
                onValueChange = { passState.value = it },
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Leading Icon") },
                modifier = modifier
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.disabled) {
                Text(text = "Forgot Password?", textAlign = TextAlign.End, modifier = modifier)
            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Button(
                onClick = {}, modifier = modifier, shape = Shapes.medium,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = organist,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(16.dp)
            ) {
                Text(text = "log in")
            }
        }
    }
}
