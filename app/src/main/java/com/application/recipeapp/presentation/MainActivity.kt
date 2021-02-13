package com.application.recipeapp.presentation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.ArrayMap
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.textInputServiceFactory
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.application.recipeapp.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContent {
//            Column(
//                    modifier =
//                    Modifier.fillMaxWidth()
//            ){
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .border(border = BorderStroke(width = 1.dp, color = Color.Black)),
//                    verticalArrangement = Arrangement.Center
//            ) {
//                Text(
//                    text = "Text1",
//                    modifier = Modifier.align(Alignment.CenterHorizontally) //in columns children
//                                                                            //can only be aligned horizontally
//                )
//            }
//            Spacer(modifier = Modifier.padding(20.dp))
//
//            Row(modifier = Modifier
//                    .width(200.dp)
//                    .height(200.dp)
//                    .border(border = BorderStroke(width = 1.dp, color = Color.Black)),
//                    horizontalArrangement = Arrangement.Center
//            ){
//                Text(
//                     text = "ITEM2",
//                modifier = Modifier.align(Alignment.CenterVertically)
//                )
//            }
//        }
//      }
        setContent{
            ScrollableColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFF2F2F2))
            )
            {
                Image(
                    bitmap = imageFromResource
                        (res = resources,
                        resId = R.drawable.happy_meal_small
                    ),
                    modifier = Modifier.height(300.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ){
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(
                            text = "Happy Meal",
                            modifier = Modifier.align(Alignment.CenterVertically),
                            style = TextStyle(
                                fontSize = TextUnit.Companion.Sp(26)
                            )
                        )
                        Text(
                            text = "$5.99",
                            style = TextStyle(
                                color = Color(0xFF85bb65),
                                fontSize = TextUnit.Companion.Sp(17)
                            ),
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.padding(top = 10.dp))
                    Text(
                        text = "800 Calories",
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(17)
                        )
                    )
                    Spacer(modifier = Modifier.padding(top = 10.dp))

                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier.align(Alignment.CenterHorizontally)) {
                        Text(text = "Order Now")
                    }
                }
            }
        }
    }
}