package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.card.TwoColumnCardGrid
import com.example.myapplication.ui.SearchBar.SearchBar
import com.example.myapplication.ui.groceryListButton.GroceryListButton

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Remember navController for navigating between screens
            val navController = rememberNavController()
            MyApplicationTheme {
                // Wrap the UI with NavHost for navigation
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(navController)
                    }
                    composable("GroceryList") {
                        GroceryList()
                    }
                    // Add more screens here as necessary
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    MyApplicationTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                // Add SearchBar to the topBar
                SearchBar()
            }
        ) { innerPadding ->
            // Apply innerPadding to avoid content overlap
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                // CardPreview content
                CardPreview(modifier = Modifier.fillMaxSize())

                // GroceryListButton positioned at the bottom
                GroceryListButton(
                    onClick = { /* Handle click */ },
                    navController = navController,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp) // Optional padding for spacing
                )
            }
        }
    }
}

@Composable
fun GroceryList() {
    // Generated List of ingredients from added Recipes
    Text("This is the Grocery List Screen")
}

@Composable
fun CardPreview(modifier: Modifier = Modifier) {
    val items: List<Pair<String, Int>> = listOf(
        "Item 1" to R.drawable.sample_photo,
        "Item 2" to R.drawable.sample_photo,
        "Item 3" to R.drawable.sample_photo,
        "Item 4" to R.drawable.sample_photo,
        "Item 5" to R.drawable.sample_photo,
        "Item 6" to R.drawable.sample_photo,
        "Item 7" to R.drawable.sample_photo,
        "Item 8" to R.drawable.sample_photo,
        "Item 9" to R.drawable.sample_photo,
        "Item 10" to R.drawable.sample_photo,
    )
    TwoColumnCardGrid(items)
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    HomeScreen(navController = rememberNavController()) // Preview everything put together
}


@Preview
@Composable
fun PreviewButton() {
    // Mock NavController for preview purposes
    val navController = rememberNavController()

    Box(
        modifier = Modifier
            .fillMaxSize() // Ensure the Box takes up the entire available space
    ) {
        GroceryListButton(
            onClick = {},
            navController = navController,
            modifier = Modifier
                .align(Alignment.BottomCenter) // Align the button at the bottom center
                .padding(16.dp) // Padding around the button
        )
    }
}




