package com.example.myapplication.ui.groceryListButton

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun GroceryListButton(onClick: () -> Unit, navController: NavController, modifier: Modifier) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Gray) // Adds a background to the button
            .border(1.dp, Color.Black) // Adds a border to help visibility
    ) {
        Text("Grocery List")
    }
}
