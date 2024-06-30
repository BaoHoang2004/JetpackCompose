package com.example.asm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.asm.Detail
import com.example.asm.Favourite
import com.example.asm.Home
import com.example.asm.Notification
import com.example.asm.Person
import com.example.asm.bottomtab.Destinations

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Destinations.Home.route ){
        composable(Destinations.Home.route){
            Home(navController)
        }
        composable(Destinations.Favourite.route){
            Favourite()
        }
        composable(Destinations.Notification.route){
            Notification()
        }
        composable(Destinations.Person.route){
            Person()
        }

    }

}