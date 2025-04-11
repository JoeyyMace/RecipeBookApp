package com.example.myapplication.ui.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.Recipe
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FindRecipeScreen(recipes: List<Recipe>) {
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = recipes.size, // Number of pages, each page is a recipe
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        val recipe = recipes[page]

        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = recipe.imageResId),
                contentDescription = "Recipe Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .border(1.dp, Color.Black)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.padding(16.dp)) {
                // Name Text with custom font and weight
                Text(
                    text = "Name: ${recipe.name}",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))

                // Prep Time Text with custom color and font size
                Text(
                    text = "Prep Time: ${recipe.prepTime}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Gray,
                        fontSize = 18.sp,
                        letterSpacing = 1.5.sp
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))

                // Calories Text with a custom font weight
                Text(
                    text = "Calories: ${recipe.calories}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))

                // Ingredients Text with custom style and line height
                Text(
                    text = "Ingredients: ${recipe.ingredients.joinToString(", ")}",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        lineHeight = 24.sp
                    )
                )
            }
        }
    }
}





















