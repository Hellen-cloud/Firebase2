package com.hellena.firebase2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hellena.firebase2.ui.theme.screens.SplashScreen
import com.hellena.firebase2.ui.theme.screens.dashboard.DashboardScreen
import com.hellena.firebase2.ui.theme.screens.login.LoginScreen
import com.hellena.firebase2.ui.theme.screens.products.AddproductScreen
import com.hellena.firebase2.ui.theme.screens.products.UpdateproductScreen
import com.hellena.firebase2.ui.theme.screens.products.ViewProducts
import com.hellena.firebase2.ui.theme.screens.register.RegisterScreen

@Composable
fun AppNavHost(navController:NavHostController = rememberNavController(),startDestination:String= ROUTE_SPLASH){
    NavHost(navController=navController,startDestination=startDestination){
        composable(ROUTE_SPLASH){ SplashScreen {
            navController.navigate(ROUTE_DASHBOARD) {
                popUpTo(ROUTE_SPLASH){inclusive=true}} }}
        composable(ROUTE_REGISTER) { RegisterScreen(navController) }
        composable(ROUTE_LOGIN) { LoginScreen(navController) }
        composable(ROUTE_DASHBOARD){ DashboardScreen(navController) }
        composable(ROUTE_ADD_PRODUCT){ AddproductScreen(navController) }
        composable(ROUTE_VIEW_PRODUCTS){ ViewProducts(navController) }
        composable("$ROUTE_UPDATE_PRODUCT/{productId}") {
                passedData -> UpdateproductScreen(
            navController, passedData.arguments?.getString("productId")!! )
        }
    }

}