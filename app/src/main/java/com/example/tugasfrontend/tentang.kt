package com.example.tugasfrontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.tugasfrontend.ui.theme.TugasFrontEndTheme

class TentangScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasFrontEndTheme {
                tentang()
            }
        }
    }
}

@Composable
fun tentang() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ProfileHeader()
        Spacer(modifier = Modifier.height(16.dp))
        Text("Detail Menu", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        MenuItem(
            imageRes = R.drawable.udangkeju,
            title = "Udang Keju",
            sold = "10RB+ terjual",
            liked = "Disukai oleh 6,7RB"
        )
        MenuItem(
            imageRes = R.drawable.combats,
            title = "Gacoan Combat",
            sold = "10RB+ terjual",
            liked = "Disukai oleh 6,7RB"
        )
        MenuItem(
            imageRes = R.drawable.festa,
            title = "Gacoan Fest A",
            sold = "10RB+ terjual",
            liked = "Disukai oleh 6,7RB"
        )
        MenuItem(
            imageRes = R.drawable.mieg,
            title = "Mie Gacoan",
            sold = "10RB+ terjual",
            liked = "Disukai oleh 6,7RB"
        )
        MenuItem(
            imageRes = R.drawable.greentea,
            title = "Thai Green Tea",
            sold = "10RB+ terjual",
            liked = "Disukai oleh 6,7RB"
        )
    }
}

@Composable
fun ProfileHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.foto),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(110.dp)
                .background(Color.Gray, CircleShape)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text("Ikhsanul Arifin", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text("lubis163774@gmail.com")
            Text("Tel-U Purwokerto")
            Text("Teknik Informatika")
        }
    }
}

@Composable
fun MenuItem(imageRes: Int, title: String, sold: String, liked: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color(0xFF9fafca), RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier.size(60.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(sold, color = Color.Black, fontSize = 14.sp)
            Text(liked, color = Color.Black, fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun tentangPreview() {
    TugasFrontEndTheme {
        tentang()
    }
}
