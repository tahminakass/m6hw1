package com.example.m6hw1.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier



@Composable
fun RegistrationScreen(onNavigateConfirmation: (String) -> Unit) {
    var userName by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Register")
        TextField(
            value = userName ,
            onValueChange = { userName = it},
            label =  { Text(text = "Enter your name")}
        )
        Button(onClick = { onNavigateConfirmation(userName) }) {
            Text(text = "Confirm")

        }

    }
}