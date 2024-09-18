package com.example.lab6

import android.media.Image
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.data.Group
import kotlinx.coroutines.internal.OpDescriptor



val robotoFontFamily = FontFamily(
    Font(R.font.roboto_bold, FontWeight.Bold)
)

@Composable
fun Home(
    modifier: Modifier = Modifier,
    onMenuButtonClick: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ){
            IconButton(onClick = { onMenuButtonClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.btn_menu),
                    contentDescription = "btn_menu",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Red
                )
            }

            Spacer(modifier = Modifier.padding(horizontal = 24.dp))


            Text(
                text = "POPULAR RECIPES",
                modifier = Modifier,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                fontSize = 23.sp
            )



            Spacer(modifier = Modifier.padding(horizontal = 24.dp))
            Icon(
                painter = painterResource(id = R.drawable.btn_search),
                contentDescription = "search",
                modifier = Modifier
                    .size(24.dp),
                tint = Color.Red
            )

        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "APPETIZERS")
                Spacer(modifier = Modifier.padding(horizontal = 24.dp))
                Text(text = "ENTREES")
                Spacer(modifier = Modifier.padding(horizontal = 24.dp))
                Text(text = "DESSERT")
            }
            Spacer(modifier = Modifier.padding(vertical = 12.dp))

            CarouselBoxes()


            Stars(1,modifier = Modifier.fillMaxWidth(), countStars = 3.5f, fillMaxWidth = true)

            Text(
                text = "Prime Rib Roast",
                modifier = Modifier
                    .padding(vertical = 20.dp),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF19597D),
                fontSize = 20.sp

            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.6f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.tiempo),
                        contentDescription = "tiempo",
                        modifier = Modifier
                            .size(15.dp),
                        tint = Color.Red
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Text(text = "5HR")
                }

                Row (verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.favorite),
                        contentDescription = "favorito",
                        modifier = Modifier
                            .size(15.dp),
                        tint = Color.Red
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Text(text = "685")
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.comments),
                        contentDescription = "comentarios",
                        modifier = Modifier
                            .size(15.dp),
                        tint = Color.Red
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 3.dp))
                    Text(text = "107")
                }
            }
            Text(
                text = "The Prime Rib Roast is a classic and tender cut of beef taken from the rib primal cut.  Learn how to make the perfect prime rib roast to serve your family and friends.  Check out What’s Cooking America’s award-winning Classic Prime Rib Roast recipe and photo tutorial to help you make the Perfect Prime Rib Roast.",
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth(),
                fontSize = 16.sp,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Light,
                color = Color.Gray,
                textAlign = TextAlign.Center

            )
        }
    }
}




@Composable
fun MenuDesplegable(
    modifier: Modifier = Modifier,
    onMenuButtonClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight()
                .background(color = Color(0xFFF28B82)) // Color similar al de la segunda imagen
                .padding(16.dp), // Espaciado interno
            verticalArrangement = Arrangement.SpaceBetween // Para distribuir los elementos
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp) // Espaciado entre los textos
            ) {
                Text(
                    text = "POPULAR RECIPES",
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
                Text(
                    text = "SAVED RECIPES",
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    text = "SHOPPING LIST",
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    text = "SETTINGS",
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            // Imagen y nombre alineados en la parte inferior
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.photo3),
                    contentDescription = "photo",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(50.dp)) // Para la imagen redondeada
                )
                Spacer(modifier = Modifier.height(8.dp)) // Espaciado entre la imagen y el nombre
                Text(
                    text = "HARRY TRUMAN",
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }

        IconButton(
            onClick = { onMenuButtonClick() },
            modifier = Modifier
                .align(Alignment.Top)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.btn_menu),
                contentDescription = "btn_menu",
                modifier = Modifier.size(24.dp),
                tint = Color.Red
            )
        }
    }
}
