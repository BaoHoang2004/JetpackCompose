package com.example.asm

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.asm.services.ViewModelApp

@Composable
fun Home( navController: NavHostController, viewModelApp: ViewModelApp = viewModel(),) {
    val listCate by viewModelApp.listCate
    val listProduct by viewModelApp.listProduct
    val context = LocalContext.current

    var cateID by remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {
        viewModelApp.getCategoryViewModel()
    }

    LaunchedEffect(key1 = cateID) {
        viewModelApp.getProductByCateIDViewModel(cateID)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "",
                modifier = Modifier.size(24.dp))
            Box() {
                Text(
                    buildAnnotatedString {
                    append("Make home\n")
                    withStyle(style = SpanStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700),
                        color = Color.Black,
                    )
                    ) {
                        append("BEAUTIFUL")
                    }
                },
                    style = TextStyle(
                        fontSize = 18.sp,
                        lineHeight = 25.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF909090),
                        textAlign = TextAlign.Center,
                    )
                )

            }
            Image(painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { navController.navigate("Cart") }
            )
        }
        LazyRow(
            modifier = Modifier.padding(start = 20.dp, top = 20.dp)
        ) {
            items(listCate){
                item -> Column(
                modifier = Modifier
                    .padding(end = 25.dp)
                    .clickable {
                        cateID = item.cateID
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                    Box(modifier = Modifier
                        .size(44.dp)
                        .background(
                            if (item.cateID == cateID) Color(0xFFBEBEBE) else Color(
                                0xFFF5F5F5
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ),
                        contentAlignment = Alignment.Center,

                        ){
                        AsyncImage(model = item.image,
                            contentDescription = "",
                            modifier = Modifier.size(20.dp))
                    }

                Text(text = item.cateName)
            }
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
            items(listProduct){
                item -> Box(
                    modifier = Modifier
                        .width(157.dp)
                        .height(253.dp)
                        .clickable {
                            navController.navigate("Detail/${item.productID}")
                        },


                ) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .offset(y = 160.dp, x = 117.dp)
                        .background(
                            Color(0x66606060),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clickable { navController.navigate("Detail/${item.productID}") }
                ) {
                    Image(painter = painterResource(id = R.drawable.ic_shopping),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(top = 5.dp, start = 5.dp)
                            .size(20.dp)
                            )
                }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(model = item?.image,
                            contentDescription = "",
                            modifier = Modifier
                                .width(157.dp)
                                .height(180.dp)
                            ,
                        )
                        Text(text = item.productName,
                            fontSize = 14.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF606060),
                            textAlign = TextAlign.Left,
                            maxLines = 1,
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .fillMaxWidth()


                        )
                        Text(text = "${item.price} đ",
                            fontSize = 14.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF303030),
                            textAlign = TextAlign.Left,
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .fillMaxWidth(),

                            )
                    }

                }

            }
        }
    }
}


