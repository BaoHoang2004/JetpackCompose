package com.example.asm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.asm.services.ViewModelApp


@Composable
fun Detail(
    idProduct: Int?,
    navController: NavHostController,
    viewModelApp: ViewModelApp = viewModel()
) {
    val detailProduct by viewModelApp.detailProduct

    var soLuong by remember {
        mutableStateOf(1)
    }

    fun NhanCong() {
        soLuong = soLuong + 1
    }

    fun NhanTru() {
        soLuong = soLuong - 1
    }

    LaunchedEffect(Unit) {
        viewModelApp.getProductByIDViewModel(idProduct.toString())
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .height(455.dp)
                .padding(start = 52.dp)
                .background(
                    Color.White,
                    RoundedCornerShape(
                        bottomStart = 50.dp
                    )
                )
        ) {
            AsyncImage(
                model = detailProduct?.image,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.Center)
            )
            Box(modifier = Modifier
                .size(40.dp)
                .offset(x = -20.dp, y = 59.dp)
                .background(
                    Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(6.dp)
                )
                .clickable { navController.popBackStack() }
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier
                    .height(192.dp)
                    .width(64.dp)
                    .offset(x = -32.dp, y = 155.dp)
                    .background(
                        Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(40.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 15.dp, bottom = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_white),
                        contentDescription = "",
                        modifier = Modifier.size(34.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_brow),
                        contentDescription = "",
                        modifier = Modifier.size(34.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_brownhat),
                        contentDescription = "",
                        modifier = Modifier.size(34.dp)
                    )
                }
            }

        }
        Column(
            modifier = Modifier.padding(horizontal = 30.dp)
        ) {
            detailProduct?.let {
                Text(
                    text = it.productName,
                    modifier = Modifier.padding(top = 25.dp),
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF303030),
                    )
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = "${detailProduct?.price} đ",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF303030),

                        )
                )
                Row(
                    modifier = Modifier
                        .width(113.dp)
                        .height(30.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_cong),
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { NhanCong() }
                    )
                    Text(
                        text = "${soLuong}",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF242424),
                            letterSpacing = 0.9.sp,
                        )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_tru),
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable(enabled = soLuong > 1) { NhanTru() }
                    )
                }

            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_start),
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text = "4",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF303030),
                    ),
                    modifier = Modifier.padding(start = 10.dp)
                )
                Text(
                    text = "(50 reviews)",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF808080),
                    ),
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
            Text(
                text = "Minimal Stand is made of by natural wood. The design that is very simple and minimal. This is truly one of the best furnitures in any family for now. With 3 different colors, you can easily select the best match for your home. ",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight(300),
                    color = Color(0xFF606060),
                    textAlign = TextAlign.Justify,
                ),
                modifier = Modifier
                    .height(150.dp)
                    .padding(top = 14.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(
                            Color(0xFFF0F0F0),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(18.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_favourite),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )
                }
                Button(
                    onClick = { navController.navigate("Cart") },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(250.dp)
                        .height(60.dp)

                ) {
                    Text(
                        text = "Get Started",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                        modifier = Modifier
                            .width(101.dp)
                            .height(23.dp)
                    )

                }
            }
        }

    }
}