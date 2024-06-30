package com.example.asm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.asm.Cart
import com.example.asm.CheckOut
import com.example.asm.Detail
import com.example.asm.Home
import com.example.asm.Login
import com.example.asm.Payment
import com.example.asm.PaymentSuccess
import com.example.asm.Register
import com.example.asm.Wellcome
import com.example.asm.bottomtab.BottomTab

@Composable
fun AppNavigation(modifier: Modifier = Modifier,onNavigate: NavHostController) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "Wellcome") {
        composable("Wellcome"){
            Wellcome(navController)
        }
        composable("Login"){
            Login (navController)
        }
        composable("Register"){
            Register(navController)
        }
        composable("Home"){
            Home(navController)
        }
        composable("PaymentSuccess") {
            PaymentSuccess(navController)
        }
        composable("Payment"){
            Payment(navController)
        }
        composable("CheckOut"){
            CheckOut(navController)
        }
        composable("BottomTab"){
            BottomTab(navController = navController)
        }
        composable("Detail/{idProduct}",
            arguments = listOf(navArgument("idProduct"){type= NavType.IntType})
        ){backStackEntry->
            Detail(

                idProduct = backStackEntry.arguments?.getInt("idProduct"),
                navController
            )
        }
        composable("Cart"){
            Cart(navController)
        }

    }
}