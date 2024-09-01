package com.example.lab6

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.data.Group


@Composable
fun Home(
    modifier: Modifier = Modifier
){

    val robotoFontFamily = FontFamily(
        Font(R.font.roboto_bold, FontWeight.Bold)
    )

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ){
            Icon(
                painter = painterResource(id = R.drawable.btn_menu),
                contentDescription = "btn_menu",
                modifier = Modifier
                    .size(24.dp),
                tint = Color.Red
            )
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
            LazyRow (
                modifier = Modifier
            ){
                item {
                    Box(
                        modifier = Modifier
                            .size(250.dp)
                            .clip(RoundedCornerShape(20.dp))
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.costilla),
                            contentDescription = "costilla",
                            modifier = Modifier
                                .fillMaxSize()
                        )
                        Icon(
                            imageVector = Icons.Filled.FavoriteBorder,
                            contentDescription = "favorite",
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(16.dp)
                                .size(24.dp),
                            tint = Color.White
                        )
                    }

                }
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 10.dp)
            ){
                val rating: Float = 5f

                val fullStars = rating.toInt()

                val hasHalfStar = (rating-fullStars)>=0.5

                // Dibuja estrellas llenas
                for (i in 1..fullStars) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star",
                        tint = Color(0xFFFFD700), // Color dorado
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Dibuja una media estrella si es necesario
                if (hasHalfStar) {
                    Icon(
                        imageVector = Icons.Filled.StarHalf,
                        contentDescription = "Half Star",
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Dibuja estrellas vacías para completar 5
                val emptyStars = if (hasHalfStar) 5 - fullStars - 1 else 5 - fullStars
                for (i in 1..emptyStars) {
                    Icon(
                        imageVector = Icons.Outlined.StarOutline,
                        contentDescription = "Empty Star",
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
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
