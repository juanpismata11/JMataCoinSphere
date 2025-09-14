package com.example.coinsphere

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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

data class Criptos(
    val id: Int,
    val imagen: String,
    val titulo: String,
    val valor: String
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

    val criptomonedas = listOf(
        Criptos(1, "bitcoin.png", "Bitcoin", "$109,797.37"),
        Criptos(2, "ethereum.png", "Ethereum", "$4,321.21"),
        Criptos(3, "tether.png", "Tether", "$1.0000"),
        Criptos(4, "xrp.png", "XRP", "$2.8100"),
        Criptos(5, "bnb.png", "BNB", "$845.0000"),
        Criptos(6, "solana.png", "Solana", "$201.8500"),
        Criptos(7, "usdc.png", "USDC", "$0.9998"),
        Criptos(8, "dogecoin.png", "Dogecoin", "$0.1320"),
        Criptos(9, "tron.png", "TRON", "$0.3630")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(top = 25.dp)
    ){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            text = "CoinSphere",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        ){
            Text(
                text = "#     Name",
                color = TextDim
            )

            Text(
                modifier = Modifier
                    .padding(start = 150.dp),
                text = "Price",
                color = TextDim
            )
        }

        Divider(
            color = Surface,
            thickness = 3.dp
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(criptomonedas) { criptos ->
                Card(
                    modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Surface
                    ),
                    shape = RoundedCornerShape(16.dp)
                ){

                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Column(
                            modifier = Modifier
                                .width(210.dp)
                        ){
                            Row(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text(
                                    modifier = Modifier
                                        .padding(end = 10.dp),
                                    text = criptos.id.toString(),
                                    color = TextDim
                                )

                                Text(
                                    modifier = Modifier
                                        .padding(end = 10.dp),
                                    text = "img",
                                    color = Color.White
                                )

                                Text(
                                    modifier = Modifier
                                        .padding(end = 40.dp),
                                    text = criptos.titulo,
                                    fontWeight = FontWeight.Bold,
                                    color = TextMain
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = criptos.valor,
                                color = TextDim
                            )
                        }
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