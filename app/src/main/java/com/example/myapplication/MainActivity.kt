package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.data.Recipe
import com.example.myapplication.ui.card.FindRecipeScreen
import com.example.myapplication.ui.nav.GroceryList
import com.example.myapplication.ui.nav.HomeScreen
import com.example.myapplication.ui.nav.ProfileScreen
import com.example.myapplication.ui.nav.RecipesScreen
import com.example.myapplication.ui.nav.SettingsScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainLayout()
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainLayout() {
        val navController = rememberNavController()
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            gesturesEnabled = false,
            drawerContent = {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFDDAA)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(32.dp)
                    ) {
                        // Close Button
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            IconButton(onClick = {
                                scope.launch { drawerState.close() }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close Drawer"
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Your drawer navigation content
                        DrawerContent(
                            onDestinationClicked = { route ->
                                scope.launch {
                                    drawerState.close()
                                    navController.navigate(route) {
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            }
                        )
                    }
                }
            }
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Pocket Recipe") },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch { drawerState.open() }
                            }) {
                                Icon(Icons.Default.Menu, contentDescription = null)
                            }
                        }
                    )
                }
            ) { padding ->
                NavHost(
                    navController = navController,
                    startDestination = "home",
                    modifier = Modifier.padding(padding)
                ) {
                    composable("home") { HomeScreen() }
                    composable("book") { FindRecipeScreen(recipes = sampleRecipes) }
                    composable("settings") { SettingsScreen() }
                    composable("profile") { ProfileScreen() }
                    composable("recipes") { RecipesScreen() }
                    composable("grocery list") { GroceryList() }
                }
            }
        }
    }
}

val sampleRecipes = listOf(
    Recipe(
        name = "Spaghetti Carbonara",
        prepTime = "20 minutes",
        calories = "600 kcal",
        ingredients = listOf("Spaghetti", "Eggs", "Pancetta", "Parmesan", "Garlic", "Olive oil", "Black pepper"),
        imageResId = R.drawable.carbonara // Replace with actual image resource ID
    ),
    Recipe(
        name = "Chicken Salad",
        prepTime = "15 minutes",
        calories = "350 kcal",
        ingredients = listOf("Chicken breast", "Lettuce", "Tomatoes", "Cucumber", "Olive oil", "Lemon", "Salt", "Pepper"),
        imageResId = R.drawable.chickensalad // Replace with actual image resource ID
    ),
    Recipe(
        name = "Grilled Cheese Sandwich",
        prepTime = "10 minutes",
        calories = "450 kcal",
        ingredients = listOf("Bread", "Cheddar cheese", "Butter"),
        imageResId = R.drawable.grilledcheese // Replace with actual image resource ID
    ),
    Recipe(
        name = "Vegetable Stir Fry",
        prepTime = "25 minutes",
        calories = "300 kcal",
        ingredients = listOf("Bell peppers", "Carrots", "Broccoli", "Soy sauce", "Garlic", "Olive oil"),
        imageResId = R.drawable.stirfry // Replace with actual image resource ID
    ),
    Recipe(
        name = "Pancakes",
        prepTime = "30 minutes",
        calories = "400 kcal",
        ingredients = listOf("Flour", "Milk", "Eggs", "Butter", "Sugar", "Baking powder", "Vanilla extract"),
        imageResId = R.drawable.pancakes // Replace with actual image resource ID
    )
)

@Preview(showBackground = true)
@Composable
fun PreviewFindRecipeScreen() {
    FindRecipeScreen(recipes = sampleRecipes)
}






