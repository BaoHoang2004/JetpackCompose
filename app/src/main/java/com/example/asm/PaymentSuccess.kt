package com.example.asm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
fun PaymentSuccess(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "SUCCESS!",
            style = TextStyle(
                fontSize = 36.sp,
                lineHeight = 35.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,
                letterSpacing = 1.8.sp,
            ),
            modifier = Modifier
                .padding(top = 130.dp)
        )
        Box(
            modifier = Modifier
                .padding(30.dp)
                .width(268.98279.dp)
                .height(230.dp)
        ){
            Image(painter = painterResource(id = R.drawable.background_paymentsuccess),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.None)
            Image(painter = painterResource(id = R.drawable.img_paymentsuccess),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.None)
            Image(painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .offset(x = 110.dp, y = 205.dp),
                )
        }
        Text(
            text = "Your order will be delivered soon.\nThank you for choosing our app!",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 27.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF606060),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .width(283.dp)
                .height(54.dp)
        )
        Button(
            onClick = {  },
            modifier = Modifier
                .padding(top = 40.dp)
                .shadow(
                    elevation = 20.dp,
                    spotColor = Color(0x40303030),
                    ambientColor = Color(0x40303030)
                )
                .width(315.dp)
                .height(60.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF242424))
        ) {
            Text(
                text = "Track your orders",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),

                    textAlign = TextAlign.Center,
                )
            )
        }
        Button(
            onClick = { navController.navigate("Home") },
            modifier = Modifier
                .padding(top = 25.dp)
                .shadow(
                    elevation = 20.dp,
                    spotColor = Color(0x40303030),
                    ambientColor = Color(0x40303030)
                )
                .width(315.dp)
                .height(60.dp)
                .border(width = 1.dp, color = Color(0xFF303030), shape = RoundedCornerShape(8.dp)),

            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF))
        ) {
            Text(
                text = "Track your orders",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF303030),
                    textAlign = TextAlign.Center,
                )
            )
        }

    }
}