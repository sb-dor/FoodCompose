package com.example.foodcompose.features.main_app_feature.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodcompose.features.invoice_feature.presentation.mvvm.InvoiceFeatureViewModel
import com.example.foodcompose.features.main_app_feature.presentation.pages.screens.food_about_screen.FoodAboutScreen
import com.example.foodcompose.features.main_app_feature.presentation.pages.screens.food_screen.FoodScreen
import com.example.foodcompose.features.main_app_feature.presentation.pages.screens.main_screen.MainScreen
import com.example.foodcompose.features.main_app_feature.presentation.vmmv.MainAppFeatureViewModel
import androidx.lifecycle.viewmodel.compose.viewModel as viewModel


enum class AppScreenPath {
    MainScreen, FoodScreen, FoodAboutScreen
}

@Composable
fun MainAppPage() {
    //
    val navigationController = rememberNavController();

    //
    Scaffold(topBar = {
        AppTopBar()
    }) { paddingValues ->
        NavigationForMainAppPage(paddingValues, navigationController)
    }

}

@Composable
private fun NavigationForMainAppPage(
    paddingValues: PaddingValues, navigationController: NavHostController
) {
    NavHost(
        navController = navigationController, startDestination = AppScreenPath.MainScreen.name
    ) {
        composable(route = AppScreenPath.MainScreen.name) {
            MainScreen(paddingValues = paddingValues, navigationController = navigationController)
        }
        composable(route = AppScreenPath.FoodScreen.name) {
            FoodScreen(paddingValues = paddingValues, navHostController = navigationController)
        }
        composable(route = AppScreenPath.FoodAboutScreen.name) {
            FoodAboutScreen(paddingValues = paddingValues, navHostController = navigationController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(viewModel: InvoiceFeatureViewModel = viewModel()) {


    val cartState by viewModel.uiState.collectAsState()

    TopAppBar(
        title = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "PIZZA",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 28.sp,
                            lineHeight = 0.1.sp
                        )
                        Text(
                            text = "Upgrade my plan",
                            fontSize = 12.sp,
                            lineHeight = 0.5.sp,
                            color = Color.Blue
                        )
                    }
                    Box {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Default.ShoppingCart,
                                contentDescription = "Menu Desc",
                                modifier = Modifier.size(30.dp)
                            )
                        }
//                        if (cartState.isNotEmpty()) {
                        Badge {
                            Text(
                                text = "${cartState.invoiceDetails.size}",
                                color = Color.White
                            )
                        }
//                        }
                    }
                }
            }
        },
    )
}