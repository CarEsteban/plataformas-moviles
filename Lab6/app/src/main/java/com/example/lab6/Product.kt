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
    "Deliciously soft and chewy cookies loaded with semi-sweet chocolate chips. These cookies are the ultimate comfort dessert, with a crispy edge and gooey center. Perfect for an afternoon snack or dessert, and they pair perfectly with a glass of cold milk.",
    "The Prime Rib Roast is a classic and tender cut of beef taken from the rib primal cut.  Learn how to make the perfect prime rib roast to serve your family and friends.  Check out What’s Cooking America’s award-winning Classic Prime Rib Roast recipe and photo tutorial to help you make the Perfect Prime Rib Roast."
)

val shoppingsList = listOf(
    "1 pound ribeye steak or your preferred cut\n" + "2 tablespoons olive oil\n" + "4 cloves garlic, minced\n" + "1 sprig fresh rosemary\n" + "Salt to taste\n" + "Freshly ground black pepper to taste\n" + "1 lemon (optional, for garnish)\n" + "2 cups grilled vegetables (zucchini, bell peppers, or asparagus)\n",
    "2 tablespoons olive oil\n" + "1 onion, chopped\n" + "2 cloves garlic, minced\n" + "4 carrots, chopped\n" + "4 celery stalks, chopped\n" + "2 potatoes, diced\n" + "1 can diced tomatoes (14.5 oz)\n" + "6 cups vegetable broth\n" + "1 teaspoon thyme\n" + "1 bay leaf\n" + "Salt to taste\n" + "Pepper to taste\n",
    "1 pizza dough (homemade or store-bought)\n" + "1/2 cup tomato sauce\n" + "8 ounces fresh mozzarella cheese, sliced\n" + "1/4 cup fresh basil leaves\n" + "1 tablespoon olive oil\n" + "Salt to taste\n" + "Freshly ground black pepper to taste\n",
    "1 1/2 cups all-purpose flour\n" + "3 1/2 teaspoons baking powder\n" + "1 teaspoon salt\n" + "1 tablespoon sugar\n" + "1 1/4 cups milk\n" + "1 egg\n" + "3 tablespoons melted butter\n" + "Maple syrup (for serving)\n" + "Whipped cream (optional, for garnish)\n",
    "2 1/4 cups all-purpose flour\n" + "1/2 teaspoon baking soda\n" + "1/2 teaspoon salt\n" + "3/4 cup unsalted butter, melted\n" + "1 cup brown sugar, packed\n" + "1/2 cup granulated sugar\n" + "1 tablespoon vanilla extract\n" + "1 egg\n" + "1 egg yolk\n" + "2 cups semisweet chocolate chips\n",
    "1 Prime Rib Roast (standing rib), approximately 8 pounds\n" +
            "1/2 cup good-quality balsamic vinegar\n" +
            "1 cup (packed) Italian parsley leaves\n" +
            "8 cloves garlic, minced\n" +
            "1/4 teaspoon salt \n" +
            "Freshly ground pepper to taste\n" +
            "Salt to taste\n" +
            "1 cup water\n" +
            "3 drops Worcestershire sauce"
)

val preparationsList = listOf(
    "1) Preheat the grill to medium-high heat. Allow the steak to sit at room temperature for 30 minutes.\n\n" + "2) Rub the steak with olive oil and season both sides generously with salt and freshly ground black pepper.\n\n" + "3) Place the steak on the grill and cook for about 4-5 minutes per side for medium-rare, or until desired doneness is reached.\n\n" + "4) In the last minute of cooking, add garlic and rosemary to the grill for extra flavor.\n\n" + "5) Let the steak rest for 5-10 minutes before slicing. Serve with grilled vegetables and a squeeze of lemon if desired.\n",
    "1) In a large pot, heat the olive oil over medium heat. Add the onions and garlic, and cook until softened, about 5 minutes.\n\n" + "2) Add the carrots, celery, and potatoes. Cook for another 5-7 minutes, stirring occasionally.\n\n" + "3) Stir in the diced tomatoes, vegetable broth, thyme, and bay leaf. Bring the soup to a boil, then reduce heat to low and let simmer for 25-30 minutes, or until the vegetables are tender.\n\n" + "4) Season with salt and pepper to taste. Remove the bay leaf before serving.\n\n" + "5) Serve hot with a slice of bread on the side if desired.\n",
    "1) Preheat your oven to 500°F (260°C). If using a pizza stone, place it in the oven while preheating.\n\n" + "2) On a floured surface, roll out the pizza dough to your desired thickness.\n\n" + "3) Transfer the dough to a baking sheet or pizza peel. Spread the tomato sauce evenly over the surface of the dough.\n\n" + "4) Arrange the mozzarella slices on top of the sauce. Drizzle with olive oil and season with salt and pepper.\n\n" + "5) Bake for 10-12 minutes or until the crust is golden and the cheese is bubbling.\n\n" + "6) Remove from the oven and immediately top with fresh basil leaves. Slice and serve hot.\n",
    "1) In a large bowl, sift together the flour, baking powder, salt, and sugar.\n\n" + "2) In a separate bowl, whisk together the milk, egg, and melted butter.\n\n" + "3) Pour the wet ingredients into the dry ingredients and stir until just combined. Do not overmix.\n\n" + "4) Heat a non-stick skillet or griddle over medium heat. Grease lightly with butter.\n\n" + "5) Pour 1/4 cup of batter onto the skillet for each pancake. Cook until bubbles form on the surface, then flip and cook the other side until golden brown.\n\n" + "6) Serve warm with maple syrup and whipped cream if desired.\n",
    "1) Preheat the oven to 350°F (175°C). Line a baking sheet with parchment paper.\n\n" + "2) In a medium bowl, whisk together the flour, baking soda, and salt. Set aside.\n\n" + "3) In a separate large bowl, cream together the melted butter, brown sugar, and granulated sugar until smooth.\n\n" + "4) Beat in the vanilla extract, egg, and egg yolk until light and creamy.\n\n" + "5) Gradually mix in the dry ingredients. Stir in the chocolate chips by hand using a wooden spoon.\n\n" + "6) Drop dough by rounded tablespoons onto the prepared baking sheet, leaving space between each cookie.\n\n" + "7) Bake for 10-12 minutes, or until the edges are lightly toasted. Let cool on the baking sheet for a few minutes before transferring to a wire rack.\n",
    "1) Preheat oven to 350 degrees F.  Let roast stand at room temperature for 1 hour.\n\n" +
            "2) In a small saucepan over medium-high heat, boil balsamic vinegar until it reduces to 1/4 cup, approximately 3 minutes.  Remove from heat and set aside.\n\n" +
            "3) Finely mince the parsley.  Mix together with the minced garlic, 1/4 teaspoon salt, and a generous amount of pepper.  Using the tip of a sharp knife, bore 7 to 10 narrow holes, each about 1 1/2\" deep, in the rib roast.  Fill the holes with the parsley-garlic mixture.  Spread any remaining mixture over the surface of the roast.  Sprinkle all sides of the meat with salt and pepper.\n\n" +
            "4) After slicing the roast, add any accumulated meat juices to the balsamic sauce.  Serve the meat slices on warmed plates with balsamic sauce on the side.\n"
)

@Composable
fun Product(
    modifier: Modifier,
    //el ID debe ir de 1 a 6
    ID: Int
){

    LazyColumn (
        modifier = Modifier.fillMaxSize().background(color = Color.White)
    ){
        item {
            BoxProduct(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .background(color = Color.Blue),
                painter = painterResource(id = images[ID-1]),
                contentDescription = "costilla"
            )

            Stars(2,modifier = Modifier.fillMaxWidth(), countStars = 3.5f, fillMaxWidth = true)


            Text(
                text = titles[ID-1],
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
                text = descriptions[ID-1],
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
                text = shoppingsList[ID-1],
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
                text = shoppingsList[ID-1],
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