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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

data class Product(
    val productID: String,
    val productName: String,
    val price: String,
    var soLuong: Int,
    val image: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cart(navController: NavHostController) {
    var listProduct = remember {
        mutableStateListOf(
            Product("1", "Minimal Stand", "3000000", 1, R.drawable.product),
            Product("2", "Coffee Table", "2000000", 1, R.drawable.product_b),
            Product("3", "Minimal Desk", "5000000", 1, R.drawable.product_c),
        )


    }


    fun NhanCong(id: String) {
        var product = listProduct.find { it.productID == id }
        if (product != null) {
            val index = listProduct.indexOf(product)
            listProduct[index] = product.copy(soLuong = product.soLuong + 1)
        }
    }

    fun NhanTru(id: String) {
        var product = listProduct.find { it.productID == id }
        if (product != null) {
            val index = listProduct.indexOf(product)
            listProduct[index] = product.copy(soLuong = product.soLuong - 1)
        }
    }



    Column(
        modifier = Modifier.fillMaxSize()
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
                text = "My cart",
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
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(listProduct) { item ->
                Box(
                    modifier = Modifier.clickable { }
                ) {
                    Row(
                        modifier = Modifier
                            .width(334.dp)
                            .height(100.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = "",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(10.dp)),

                            contentScale = ContentScale.FillBounds
                        )
                        Column(
                            modifier = Modifier
                                .width(214.dp)
                                .height(100.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(
                                    20.dp,
                                    Alignment.Start
                                ),
                                verticalAlignment = Alignment.Top
                            ) {
                                Text(
                                    text = item.productName,
                                    modifier = Modifier
                                        .width(170.dp)
                                        .height(19.dp),
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight(600),
                                        color = Color(0xFF999999),
                                    )
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.ic_close),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(24.dp)
                                        .clickable {
                                            listProduct.remove(item)
                                        }
                                )
                            }
                            Text(text = "${item.price} đ")
                            Row(
                                modifier = Modifier
                                    .padding(top = 23.dp)
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
                                        .clickable {
                                            NhanCong(item.productID)
                                        }
                                )
                                Text(
                                    text = "${item.soLuong}",
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
                                        .clickable(
                                            enabled = item.soLuong > 1
                                        ) {
                                            NhanTru(item.productID)
                                        }
                                )
                            }
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(bottom = 50.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(value = "",

                onValueChange = {},
                modifier = Modifier
                    .width(335.dp)
                    .height(50.dp)
                    .shadow(
                        elevation = 20.dp,
                        spotColor = Color(0x1F8A959E),
                        ambientColor = Color(0x1F8A959E)
                    )
                    .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(10.dp)),
                placeholder = {
                    Text(
                        text = "Enter your promo code",
                        modifier = Modifier
                            .height(22.dp),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF999999),
                        ),
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_next),
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                })
            Row(
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .width(279.dp)
                    .height(27.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total:",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF808080),

                        )
                )
                Text(
                    text = "$ 95.00",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF303030),

                        textAlign = TextAlign.Right,
                    )
                )
            }
            Button(
                onClick = { navController.navigate("CheckOut") },
                modifier = Modifier
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
                    text = "Check out",
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
}