package com.example.coinsphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coinsphere.ui.theme.Background
import com.example.coinsphere.ui.theme.CoinSphereTheme
import com.example.coinsphere.ui.theme.Purple40
import com.example.coinsphere.ui.theme.Purple80
import com.example.coinsphere.ui.theme.PurpleGrey40
import com.example.coinsphere.ui.theme.Surface
import com.example.coinsphere.ui.theme.TextDim
import com.example.coinsphere.ui.theme.TextMain

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinSphereTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(Background),
                    containerColor = Background
                ) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class Cards(
    val titulo: String,
    val descripcion: String
)


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){

    val cardsTop = listOf(
        Cards(titulo = "Global Market Cap", descripcion = "$2.18T") ,
        Cards(titulo = "Fear & Greed", descripcion = "Neutral (54)"),
        Cards(titulo = "Altcoin Season", descripcion = "No")

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            text = "CoinSphere",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = TextMain
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)

        ){
            items(cardsTop){ cards ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Surface
                    ),
                    shape = RoundedCornerShape(12.dp)
                ){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ){
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Surface),
                            text = cards.titulo,
                            color = TextDim,
                            fontSize = 12.sp
                        )

                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Surface),
                            text = cards.descripcion,
                            color = TextMain,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp

                        )

                    }
                }

            }

        }
    }
}
@Preview
@Composable
fun GreetingPreview() {
    CoinSphereTheme {
        HomeScreen()
    }
}