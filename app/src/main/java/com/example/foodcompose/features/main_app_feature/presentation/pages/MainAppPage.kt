package com.example.foodcompose.features.main_app_feature.presentation.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodcompose.features.invoice_feature.presentation.pages.InvoiceFeaturePage
import com.example.foodcompose.features.main_app_feature.presentation.vmmv.MainAppFeatureViewModel


enum class AppScreenPath {
    MainScreen, FoodScreen, FoodAboutScreen, CartScreen,
}

@Composable
fun MainAppPage() {
    //
    val navigationController = rememberNavController();


    val invoiceDetailsViewModel: InvoiceFeatureViewModel = viewModel();

    val mainAppFeatureViewModel: MainAppFeatureViewModel = viewModel();


    //
    NavigationForMainAppPage(
        navigationController,
        invoiceDetailViewModel = invoiceDetailsViewModel,
        mainAppFeatureViewModel = mainAppFeatureViewModel
    )

}

@Composable
private fun NavigationForMainAppPage(
    navigationController: NavHostController,
    invoiceDetailViewModel: InvoiceFeatureViewModel,
    mainAppFeatureViewModel: MainAppFeatureViewModel,
) {
    NavHost(
        navController = navigationController, startDestination = AppScreenPath.MainScreen.name
    ) {
        composable(route = AppScreenPath.MainScreen.name) {
            MainScreen(
                navigationController = navigationController,
                viewModel = mainAppFeatureViewModel,
                invoiceDetailsViewModel = invoiceDetailViewModel,
            )
        }
        composable(route = AppScreenPath.FoodScreen.name) {
            FoodScreen(
                navHostController = navigationController,
                mainAppFeatureViewModel = mainAppFeatureViewModel,
                invoiceDetailViewModel,
            )
        }
        composable(route = AppScreenPath.FoodAboutScreen.name) {
            FoodAboutScreen(
                navHostController = navigationController,
                invoiceFeatureViewModel = invoiceDetailViewModel,
                mainAppFeatureViewModel = mainAppFeatureViewModel
            )
        }
        composable(route = AppScreenPath.CartScreen.name) {
            InvoiceFeaturePage(navHostController = navigationController, invoiceDetailViewModel)
        }
    }
}

