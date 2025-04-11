package com.example.myapplication.ui.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

@Composable
fun TwoColumnCardGrid(items: List<Pair<String, Int>>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1), // 2 columns
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(32.dp), // Increased padding around the grid
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        items(items) { (text, imageRes) ->
            CardItem(text, imageRes)
        }
    }
}

@Composable
fun CardItem(text: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .width(400.dp)  // Set a specific width
            .height(200.dp) // Set a specific height
            .padding(4.dp) // Padding remains the same
            .border(
                width = 2.dp, // Border width
                color = Color.Gray, // Border color
                shape = RoundedCornerShape(8.dp) // Border with rounded corners
            ),
        elevation = CardDefaults.cardElevation(12.dp),
        shape = RoundedCornerShape(8.dp) // Rounded corners for the card
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp), // Increased internal padding
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = text,
                modifier = Modifier
                    .size(64.dp) // Larger image size
                    .clip(RoundedCornerShape(12.dp)) // More rounded image corners
            )
            Spacer(modifier = Modifier.width(4.dp)) // Increased horizontal space between image and text
            Text(
                text = text,
                fontSize = 8.sp, // Larger font size
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview
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

