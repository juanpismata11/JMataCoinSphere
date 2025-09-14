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
import androidx.compose.foundation.layout.size
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
import coil.compose.AsyncImage


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
        Criptos(1, "https://1000logos.net/wp-content/uploads/2018/05/Bitcoin-Logo.png", "Bitcoin", "$109,797.37"),
        Criptos(2, "https://download.logo.wine/logo/Ethereum/Ethereum-Logo.wine.png", "Ethereum", "$4,321.21"),
        Criptos(3, "https://cdn-icons-png.flaticon.com/512/825/825508.png", "Tether", "$1.0000"),
        Criptos(4, "https://cdn-icons-png.flaticon.com/512/12114/12114256.png", "XRP", "$2.8100"),
        Criptos(5, "https://assets.streamlinehq.com/image/private/w_300,h_300,ar_1/f_auto/v1/icons/vectors/bnb-2c9adc7qw85po528q8y3b.png/bnb-tss7lyzvhxyjfc9ivae0l.png?_a=DATAg1AAZAA0", "BNB", "$845.0000"),
        Criptos(6, "https://cdn.iconscout.com/icon/premium/png-256-thumb/solana-sol-icon-svg-png-download-5795323.png", "Solana", "$201.8500"),
        Criptos(7, "https://cdn-icons-png.flaticon.com/512/14446/14446285.png", "USDC", "$0.9998"),
        Criptos(8, "https://www.shareicon.net/data/512x512/2015/09/14/101012_doge_512x512.png", "Dogecoin", "$0.1320"),
        Criptos(9, "https://s2.coinmarketcap.com/static/img/coins/200x200/1958.png", "TRON", "$0.3630"),
        Criptos(10, "https://images.icon-icons.com/4044/PNG/512/avalanche_crypto_coin_icon_256894.png", "Avalanche", "$32.45")
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
                                        .padding(end = 20.dp),
                                    text = criptos.id.toString(),
                                    color = TextDim
                                )

                                AsyncImage(
                                    model = criptos.imagen,
                                    contentDescription = criptos.titulo,
                                    modifier = Modifier.size(40.dp)
                                )

                                Text(
                                    modifier = Modifier
                                        .padding(start = 20.dp),
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