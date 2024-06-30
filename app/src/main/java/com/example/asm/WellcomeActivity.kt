package com.example.asm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Wellcome(navController: NavHostController) {
    var context = LocalContext.current
    Column (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight())
        {
            Image(painter = painterResource(id = R.drawable.imgbackground),
                contentDescription = "Background image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop)
            Text(text = "MAKE YOUR",
                fontSize = 24.sp,
                fontWeight = FontWeight(600),
                lineHeight = 31.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 30.dp, top = 231.dp))
            Text(text = "HOME BEAUTIFUL",
                fontSize = 30.sp,
                fontWeight = FontWeight(700),
                lineHeight = 39.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 30.dp, top = 276.dp))
            Text(text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                fontSize = 18.sp,
                fontWeight = FontWeight(400),
                lineHeight = 35.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 59.dp, top = 349.dp).width(286.dp))
            Button(
                onClick = {navController.navigate("Login")},
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(start = 108.dp, top= 608.dp)
                    .width(159.dp)
                    .height(54.dp)
            ) {
                Text(text = "Get Started",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(600),
                    modifier = Modifier.width(101.dp).height(23.dp)
                )

            }

        }
    }
}