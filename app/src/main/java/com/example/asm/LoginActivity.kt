package com.example.asm

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.asm.services.LoginReq
import com.example.asm.services.ViewModelApp

@Composable
fun Login(navController: NavHostController, viewModelApp: ViewModelApp = viewModel()) {
    val login by viewModelApp.login
    var context = LocalContext.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var checkPassword by remember {
        mutableStateOf(false)
    }

    fun DangNhap(){
        if (email==""||password==""){
            Toast.makeText(context, "Bạn cần nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
        }else{
            var request = LoginReq(email, password)
            viewModelApp.loginViewModel(request)
        }
    }

    LaunchedEffect(key1 = login) {
        if (login != null){
            if (login?.status == true){
                navController.navigate("Home")
            }
            Toast.makeText(context, login?.message, Toast.LENGTH_SHORT).show()
        }
    }


    Column {
        Row(
            modifier = Modifier
                .padding(top = 65.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Box(
                modifier = Modifier
                    .width(105.dp)
                    .height(1.dp)
                    .background(color = Color.Black)
            ) {

            }
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    )
            Box(
                modifier = Modifier
                    .width(105.dp)
                    .height(1.dp)
                    .background(color = Color.Black)
            ) {

            }
        }
        Text(text = "Hello !",
            fontSize = 30.sp,
            fontWeight = FontWeight(400),
            lineHeight = 45.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 30.dp, start = 60.dp)
        )
        Text(text = "WELLCOME BACK",
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
            lineHeight = 45.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 60.dp)
        )
        Card(
            shape = RoundedCornerShape(0.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .padding(end = 20.dp, top = 30.dp, bottom = 20.dp)
                .fillMaxWidth(),

        ) {
            Text(text = "Email",
                modifier = Modifier.padding(start = 30.dp, top = 30.dp))
            TextField(value = email,
            onValueChange = {email = it},
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp)
                .fillMaxWidth()
                .background(Color.White),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            shape = RoundedCornerShape(0.dp),
                singleLine = true
            )

            Text(text = "Password",
                modifier = Modifier.padding(start = 30.dp, top = 30.dp))
            TextField(value = password,
                onValueChange = {password = it},
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth()
                    .background(Color.White),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                shape = RoundedCornerShape(0.dp),
                singleLine = true,
                trailingIcon = { IconButton(onClick = {checkPassword = !checkPassword}) {
                    Icon(painter = painterResource(id = R.drawable.iconeye),
                        contentDescription = "Icon",
                        modifier = Modifier
                            .size(20.dp))
                }
                },
                visualTransformation = if (checkPassword) VisualTransformation.None else PasswordVisualTransformation(),
            )
            Text(text = "Forgot Password",
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                textAlign = TextAlign.Center)
            Button(onClick = { DangNhap() },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 50.dp)
                    .width(285.dp)
                    .height(50.dp)
                    ) {
                Text(text = "Log in",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600)
                )
            }
            TextButton(onClick = { navController.navigate("Register") },
                modifier = Modifier
                    .padding(start = 128.dp, top = 30.dp, bottom = 10.dp)
                    .width(100.dp),
                ) {
                Text(text = "SING UP",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color.Black)
            }
        }


    }
}
