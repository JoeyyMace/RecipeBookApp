package com.example.myapplication.ui.nav

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.GroceryList
import com.example.myapplication.R
import kotlinx.coroutines.launch
import com.example.myapplication.ui.card.TwoColumnCardGrid


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawerExample(function: @Composable () -> Unit) {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                Divider()
                DrawerItem("Home") {
                    scope.launch { drawerState.close() }
                    navController.navigate("home")
                }
                DrawerItem("Profile") {
                    scope.launch { drawerState.close() }
                    navController.navigate("profile")
                }
                DrawerItem("Recipes") {
                    scope.launch { drawerState.close() }
                    navController.navigate("recipes")
                }
                DrawerItem("Grocery List") {
                    scope.launch { drawerState.close() }
                    navController.navigate("grocery_list")
                }
                DrawerItem("Settings") {
                    scope.launch { drawerState.close() }
                    navController.navigate("settings")
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = { Text("Navigation Drawer") },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Open Drawer")
                        }
                    }
                )
            }
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                NavigationHost(navController)
            }
        }
    }
}

@Composable
fun DrawerItem(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    )
}

@Composable
fun NavigationHost(navController: NavHostController) {
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
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("recipes") { TwoColumnCardGrid(items) }
        composable("grocery_list") { GroceryList() }
        composable("settings") { SettingsScreen() }
        composable("profile") { ProfileScreen() }
    }
}

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Home Screen")
    }
}

@Composable
fun GroceryList() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("My List")
    }
}

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Settings Screen")
    }
}

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Profile Screen")
    }
}
