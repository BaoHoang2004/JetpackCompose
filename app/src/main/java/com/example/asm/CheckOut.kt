package com.example.asm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun CheckOut(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Row(
            modifier = Modifier
                .padding(top = 50.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "Check out",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF303030),
                    textAlign = TextAlign.Center,
                )
            )
            Box(
                modifier = Modifier.size(20.dp)
            ) {}
        }
        Row(
            modifier = Modifier
                .padding(top = 19.dp)
                .width(335.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Shipping Address",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF909090),

                    )
            )
            Image(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .shadow(
                    elevation = 40.dp,
                    spotColor = Color(0x338A959E),
                    ambientColor = Color(0x338A959E)
                )
                .width(335.dp)
                .height(127.dp)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 8.dp)
                )
        ) {
            Text(
                text = "Bruno Fernandes",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF303030),
                ),
                modifier = Modifier
                    .padding(top = 15.dp, start = 20.dp)
            )
            Box(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .width(335.dp)
                    .height(2.dp)
                    .background(
                        color = Color(0xFFF0F0F0),
                        shape = RoundedCornerShape(size = 6.dp)
                    )
            )
            Text(
                text = "25 rue Robert Latouche, Nice, 06200, Côte D’azur, France",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 25.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF808080),
                ),
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp)
                    .width(296.dp),
                maxLines = 2
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 30.dp)
                .width(335.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Shipping Address",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF909090),

                    )
            )
            Image(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .shadow(
                    elevation = 40.dp,
                    spotColor = Color(0x338A959E),
                    ambientColor = Color(0x338A959E)
                )
                .width(335.dp)
                .height(68.dp)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 8.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 25.dp,
                            spotColor = Color.Gray,
                            ambientColor = Color.Gray
                        )
                        .width(64.dp)
                        .height(38.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .padding(vertical = 6.dp, horizontal = 16.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_mastercard),
                        contentDescription = "",
                        modifier = Modifier
                            .width(32.dp)
                            .height(25.dp)
                    )
                }
                Text(
                    text = "**** **** **** 3947",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF242424),
                    ),
                    modifier = Modifier.padding(start = 17.dp)
                )

            }
        }
        Row(
            modifier = Modifier
                .padding(top = 30.dp)
                .width(335.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Delivery method",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF909090),

                    )
            )
            Image(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .shadow(
                    elevation = 40.dp,
                    spotColor = Color(0x338A959E),
                    ambientColor = Color(0x338A959E)
                )
                .width(335.dp)
                .height(68.dp)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 8.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp, horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_dhl),
                    contentDescription = "",
                    modifier = Modifier
                        .width(88.75.dp)
                        .height(20.dp)
                )
                Text(
                    text = "Fast (2-3days)",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF242424),
                    ),
                    modifier = Modifier.padding(start = 17.dp)
                )

            }
        }
        Column(
            modifier = Modifier
                .padding(top = 38.dp)
                .shadow(
                    elevation = 40.dp,
                    spotColor = Color(0x338A959E),
                    ambientColor = Color(0x338A959E)
                )
                .width(335.dp)
                .height(135.dp)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(vertical = 20.dp, horizontal = 15.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Order: ",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF808080),

                        )
                )
                Text(
                    text = "$ 5.00",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF242424),

                        textAlign = TextAlign.Right,
                    )
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Delivery:",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF808080),

                        )
                )
                Text(
                    text = "$ 95.00",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF242424),

                        textAlign = TextAlign.Right,
                    )
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Total:",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF808080),

                        )
                )
                Text(
                    text = "$ 95.00",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF242424),

                        textAlign = TextAlign.Right,
                    )
                )
            }
        }
        Button(
            onClick = { navController.navigate("PaymentSuccess") },
            modifier = Modifier
                .padding(top = 25.dp)
                .shadow(
                    elevation = 20.dp,
                    spotColor = Color(0x40303030),
                    ambientColor = Color(0x40303030)
                )
                .width(335.dp)
                .height(60.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF242424))
        ) {
            Text(
                text = "SUBMIT ORDER",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),

                    textAlign = TextAlign.Center,
                )
            )
        }

    }

}