package com.example.foodcompose.features.main_app_feature.presentation.pages


import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
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
import com.example.foodcompose.features.main_app_feature.presentation.vmmv.MainAppFeatureViewModel
import dagger.hilt.android.AndroidEntryPoint


enum class AppScreenPath {
    MainScreen, FoodScreen, FoodAboutScreen, CartScreen,
}


val TopMainAppFeatureViewModel =
    compositionLocalOf<MainAppFeatureViewModel> { error("ViewModel not provided") }
val TopInvoiceFeatureViewModel =
    compositionLocalOf<InvoiceFeatureViewModel> { error("ViewModel not provided") }

@Composable
fun MainAppPage() {
    //
    val navigationController = rememberNavController();

    val invoiceFeatureViewModel: InvoiceFeatureViewModel = hiltViewModel();

    val mainAppFeatureViewModel: MainAppFeatureViewModel = hiltViewModel();

    invoiceFeatureViewModel.initLocalDatabase(LocalContext.current)
    //
    CompositionLocalProvider(
        TopMainAppFeatureViewModel provides (mainAppFeatureViewModel),
        TopInvoiceFeatureViewModel provides (invoiceFeatureViewModel)
    ) {
        NavigationForMainAppPage(
            navigationController,
//        invoiceDetailViewModel = invoiceDetailsViewModel,
//        mainAppFeatureViewModel = mainAppFeatureViewModel
        )
    }

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

