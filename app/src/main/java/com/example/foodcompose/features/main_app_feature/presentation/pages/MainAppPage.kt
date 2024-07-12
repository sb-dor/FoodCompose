package com.example.foodcompose.features.main_app_feature.presentation.pages


import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foodcompose.features.invoice_feature.presentation.mvvm.InvoiceFeatureViewModel
import com.example.foodcompose.features.main_app_feature.presentation.pages.screens.food_about_screen.FoodAboutScreen
import com.example.foodcompose.features.main_app_feature.presentation.pages.screens.food_screen.FoodScreen
import com.example.foodcompose.features.main_app_feature.presentation.pages.screens.main_screen.MainScreen
import com.example.foodcompose.features.invoice_feature.presentation.pages.InvoiceFeaturePage
import dagger.hilt.android.AndroidEntryPoint


enum class AppScreenPath {
    MainScreen, FoodScreen, FoodAboutScreen, CartScreen,
}


@Composable
fun MainAppPage() {
    //
    val navigationController = rememberNavController();


    val invoiceDetailsViewModel: InvoiceFeatureViewModel = viewModel();

    invoiceDetailsViewModel.initLocalDatabase(LocalContext.current)
    //
    NavigationForMainAppPage(
        navigationController,
//        invoiceDetailViewModel = invoiceDetailsViewModel,
//        mainAppFeatureViewModel = mainAppFeatureViewModel
    )

}

@Composable
private fun NavigationForMainAppPage(
    navigationController: NavHostController,
//    invoiceDetailViewModel: InvoiceFeatureViewModel,
//    mainAppFeatureViewModel: MainAppFeatureViewModel,
) {
    NavHost(
        navController = navigationController, startDestination = AppScreenPath.MainScreen.name
    ) {
        composable(route = AppScreenPath.MainScreen.name) {
            MainScreen(
                navigationController = navigationController,
//                viewModel = mainAppFeatureViewModel,
//                invoiceDetailsViewModel = invoiceDetailViewModel,
            )
        }
        composable(route = AppScreenPath.FoodScreen.name) {
            FoodScreen(
                navHostController = navigationController,
//                mainAppFeatureViewModel = mainAppFeatureViewModel,
//                invoiceDetailViewModel,
            )
        }
        composable(route = AppScreenPath.FoodAboutScreen.name) {
            FoodAboutScreen(
                navHostController = navigationController,
//                invoiceFeatureViewModel = invoiceDetailViewModel,
//                mainAppFeatureViewModel = mainAppFeatureViewModel
            )
        }
        composable(route = AppScreenPath.CartScreen.name) {
            InvoiceFeaturePage(
                navHostController = navigationController,
//                invoiceDetailViewModel
            )
        }
    }
}

