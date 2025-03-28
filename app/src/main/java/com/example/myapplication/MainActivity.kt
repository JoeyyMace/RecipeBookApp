package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.card.TwoColumnCardGrid

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Apply innerPadding to avoid content overlap
                    PreviewCard(modifier = Modifier.padding(innerPadding)) // Use innerPadding here
                }
            }
        }
    }
}


@Composable
fun CardPreview() {
    val items: List<Pair<String, Int>> = listOf(
        "Item 1" to R.drawable.sample_photo,
        "Item 2" to R.drawable.sample_photo,
        "Item 3" to R.drawable.sample_photo,
        "Item 4" to R.drawable.sample_photo,
    )
    TwoColumnCardGrid(items)
}

@Preview(showBackground = true)
@Composable
fun PreviewCard(modifier: Modifier = Modifier) {
    CardPreview()
}