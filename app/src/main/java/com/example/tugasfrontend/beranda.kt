package com.example.tugasfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

class BerandaScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasFrontEndTheme {
                beranda()
            }
        }
    }
}

@Composable
fun beranda() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(25.dp)
        ) {
            Text(
                text = "Beranda",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(30.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                item { CategoryTab("Flash Sale", selected = true) }
                item { CategoryTab("Gacoan Combat", selected = false) }
                item { CategoryTab("Gacoan Fest", selected = false) }
                item { CategoryTab("Dimsum", selected = false) }
                item { CategoryTab("Es Buah", selected = false) }
                item { CategoryTab("Beverage", selected = false) }
                item { CategoryTab("Beverage NP", selected = false) }
                item { CategoryTab("Jus", selected = false) }
                item { CategoryTab("Saos", selected = false) }
            }

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                item { FoodSection("Flash Sale", "Udang Keju") }
                item { FoodSection("Gacoan Combat", "Gacoan Combat") }
                item { FoodSection("Gacoan Fest", "Gacoan Fest A") }
                item { FoodSection("Mie", "Mie Gacoan") }
                item { FoodSection("Dimsum", "Udang Rambutan") }
                item { FoodSection("Es Buah", "Es Teklek") }
                item { FoodSection("Beverage", "Thai Green Tea") }
                item { FoodSection("Beverage NP", "Orange NP") }
                item { FoodSection("Jus", "Mangga") }
                item { FoodSection("Saos", "Asam Manis") }
            }
        }
    }
}

@Composable
fun CategoryTab(text: String, selected: Boolean) {
    Text(
        text = text,
        fontSize = 12.sp,
        color = if (selected) Color.White else Color.Black,
        modifier = Modifier
            .background(
                color = if (selected) Color(0xFF9fafca) else Color.White,
                shape = RoundedCornerShape(15.dp)
            )
            .padding(horizontal = 15.dp, vertical = 5.dp)
            .clickable { /* aksi klik */ }
    )
}

@Composable
fun FoodSection(title: String, itemName: String) {
    Column(modifier = Modifier.clickable { /* aksi klik */ }) {
        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(vertical = 2.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0e387a), shape = RoundedCornerShape(15.dp))
                .padding(vertical = 15.dp)
                .shadow(5.dp, shape = RoundedCornerShape(15.dp), clip = true),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = itemName,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
        }
    }
}

@Composable
fun BottomNavigationBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF9fafca), shape = RoundedCornerShape(80.dp))
            .padding(2.dp)
    ) {
        BottomNavItem(iconRes = R.drawable.home, label = "Beranda", selected = true)
        BottomNavItem(iconRes = R.drawable.menu, label = "Menu", selected = false)
        BottomNavItem(iconRes = R.drawable.profil, label = "Profil", selected = false)
    }
}

@Composable
fun BottomNavItem(iconRes: Int, label: String, selected: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(2.dp)
            .clickable { /* aksi klik */ }
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = label,
            tint = if (selected) Color.White else Color.Black,
            modifier = Modifier.size(35.dp)
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = if (selected) Color.White else Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun berandaPreview() {
    TugasFrontEndTheme {
        beranda()
    }
}
