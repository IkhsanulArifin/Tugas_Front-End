package com.example.tugasfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

class DaftarMenuScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasFrontEndTheme {
                DaftarMenu()
            }
        }
    }
}

@Composable
fun DaftarMenu(iconSize: Dp = 35.dp, onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp)
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(id = R.drawable.kembali),
                    contentDescription = "Back",
                    modifier = Modifier.size(iconSize),
                    tint = Color.Black
                )
            }
            Text(
                text = "Daftar Menu",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

        val menuItems = listOf(
            "Flash Sale", "Gacoan Combat", "Gacoan Fest", "Mie",
            "Dimsum", "Es Buah", "Beverage", "Beverage NP",
            "Jus", "Saos"
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(menuItems.size) { index ->
                MenuItemCard(menuItems[index], onItemClick = { item ->
                    println("Item clicked: $item")
                })
            }
        }
    }
}

@Composable
fun MenuItemCard(itemName: String, onItemClick: (String) -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f)
            .background(
                Color(0xFF1A3A77),
                shape = RoundedCornerShape(16.dp)
            )
            .shadow(2.dp, shape = RoundedCornerShape(10.dp), ambientColor = Color(0xFF0e387a))
            .clickable { onItemClick(itemName) }
            .padding(15.dp)
    ) {
        Text(
            text = itemName,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DaftarMenuPreview() {
    TugasFrontEndTheme {
        DaftarMenu()
    }
}
