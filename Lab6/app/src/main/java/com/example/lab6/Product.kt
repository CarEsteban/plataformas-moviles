package com.example.lab6

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Product(
    modifier: Modifier,
    ID: Int
){
    val images = listOf(
        R.drawable.carne,
        R.drawable.sopa,
        R.drawable.pizza,
        R.drawable.panqueques,
        R.drawable.galleta,
        R.drawable.costilla
    )
    val titles = listOf(
        "Grilled Steak Perfection",
        "Hearty Vegetable Soup",
        "Classic Margherita Pizza",
        "Fluffy Pancakes with Syrup",
        "Chocolate Chip Cookies",
        "Prime Rib Roast"
    )
    val descriptions = listOf(
        "A perfectly seasoned steak, grilled to your preferred doneness. Marinated in olive oil, garlic, and rosemary, this steak is tender on the inside and beautifully seared on the outside. Serve with grilled vegetables or a side of mashed potatoes for a hearty meal.",
        "A warming and nutritious soup filled with fresh vegetables like carrots, celery, potatoes, and tomatoes. Simmered in a flavorful broth with herbs like thyme and bay leaf, this soup is both comforting and healthy. Ideal for a light dinner or as a starter.",
        "A simple yet delicious pizza made with a crispy homemade dough, topped with fresh tomato sauce, mozzarella cheese, and basil leaves. Drizzled with olive oil, this pizza delivers the perfect balance of flavors, making it a favorite for all pizza lovers.",
        "Soft, golden-brown pancakes that melt in your mouth. These pancakes are light and fluffy, made with a simple batter of flour, eggs, milk, and butter. Serve with warm maple syrup and a dollop of whipped cream for the perfect breakfast treat.",
        "Chocolate Chip Cookies",
        "The Prime Rib Roast is a classic and tender cut of beef taken from the rib primal cut.  Learn how to make the perfect prime rib roast to serve your family and friends.  Check out What’s Cooking America’s award-winning Classic Prime Rib Roast recipe and photo tutorial to help you make the Perfect Prime Rib Roast."
    )
    LazyColumn (
        modifier = Modifier.fillMaxSize()
    ){
        item {
            BoxProduct(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .background(color = Color.Blue),
                painter = painterResource(id = R.drawable.costilla),
                contentDescription = "costilla"
            )

            Stars(2,modifier = Modifier.fillMaxWidth(), countStars = 3.5f, fillMaxWidth = true)


            Text(
                text = "Prime Rib Roast",
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF19597D),
                fontSize = 22.sp,
                textAlign = TextAlign.Center

            )
            Text(
                text = "The Prime Rib Roast is a classic and tender cut of beef taken from the rib primal cut.  Learn how to make the perfect prime rib roast to serve your family and friends.  Check out What’s Cooking America’s award-winning Classic Prime Rib Roast recipe and photo tutorial to help you make the Perfect Prime Rib Roast.",
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth(),
                fontSize = 18.sp,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Light,
                color = Color.Gray,
                textAlign = TextAlign.Center

            )
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.shopping),
                    contentDescription = "shopping",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center)
                )
            }

            Text(
                text = "SHOPPING LIST",
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF19597D),
                fontSize = 24.sp,
                textAlign = TextAlign.Center

            )

            Text(
                text = "1 Prime Rib Roast (standing rib), approximately 8 pounds\n" +
                        "1/2 cup good-quality balsamic vinegar\n" +
                        "1 cup (packed) Italian parsley leaves\n" +
                        "8 cloves garlic, minced\n" +
                        "1/4 teaspoon salt \n" +
                        "Freshly ground pepper to taste\n" +
                        "Salt to taste\n" +
                        "1 cup water\n" +
                        "3 drops Worcestershire sauce",
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth(),
                fontSize = 18.sp,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Light,
                color = Color.Gray,
                textAlign = TextAlign.Start

            )
        }
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.preparation),
                    contentDescription = "preparation",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center)
                )
            }

            Text(
                text = "PREPARATION",
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF19597D),
                fontSize = 24.sp,
                textAlign = TextAlign.Center

            )

            Text(
                text = "1) Preheat oven to 350 degrees F.  Let roast stand at room temperature for 1 hour.\n\n" +
                        "2) In a small saucepan over medium-high heat, boil balsamic vinegar until it reduces to 1/4 cup, approximately 3 minutes.  Remove from heat and set aside.\n\n" +
                        "3) Finely mince the parsley.  Mix together with the minced garlic, 1/4 teaspoon salt, and a generous amount of pepper.  Using the tip of a sharp knife, bore 7 to 10 narrow holes, each about 1 1/2\" deep, in the rib roast.  Fill the holes with the parsley-garlic mixture.  Spread any remaining mixture over the surface of the roast.  Sprinkle all sides of the meat with salt and pepper.\n\n" +
                        "4) After slicing the roast, add any accumulated meat juices to the balsamic sauce.  Serve the meat slices on warmed plates with balsamic sauce on the side.\n",
                modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth(),
                fontSize = 18.sp,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Light,
                color = Color.Gray,
                textAlign = TextAlign.Start

            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.comments_circle),
                    contentDescription = "preparation",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center)
                )
            }

            Text(
                text = "COMMENTS",
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(),
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF19597D),
                fontSize = 24.sp,
                textAlign = TextAlign.Center

            )

            PersonalComment(
                modifier = Modifier
                    .padding(bottom = 30.dp),
                "TOM KLEIN",
                2.5f,
                "This prime rib roast was amazing!!!",
                painterResource(R.drawable.photo1),
                "7.01.2017"
            )


            PersonalComment(
                modifier = Modifier
                    .padding(bottom = 30.dp),
                "SALLY PARKER",
                3.5f,
                "I was amazed at how little preparation this took. Just rub on the herbs and butter, let it sit for a few hours and you have an amazing piece of meat!",
                painterResource(R.drawable.photo2),
                "7.01.2017"
            )

            Spacer(modifier = Modifier.padding(bottom = 100.dp))
        }
    }
}



@Composable
fun PersonalComment(
    modifier: Modifier,
    name: String,
    starts: Float,
    comment: String,
    profilePhoto: Painter,
    date: String,
    contentDescription:String = "profilePhoto"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 25.dp)
            .padding(start = 30.dp)
            .padding(end = 50.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = profilePhoto,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(60.dp)
        )
        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
        Column {
            Stars(3, modifier = Modifier, countStars = starts, fillMaxWidth = false)
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = name,
                    modifier = Modifier
                        .padding(top = 10.dp),
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black,
                    fontSize = 20.sp

                )

                Text(
                    text = date,
                    modifier = Modifier
                        .padding(top = 10.dp),
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Gray
                )


            }
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Text(
                text = comment,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(),
                fontFamily = robotoFontFamily,
                color = Color.Gray,
                fontSize = 16.sp

            )
        }
    }
}