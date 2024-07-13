package com.example.foodcompose.features.main_app_feature.presentation.pages


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.foodcompose.features.invoice_feature.presentation.mvvm.InvoiceFeatureViewModel
import com.example.foodcompose.features.main_app_feature.presentation.pages.screens.food_about_screen.FoodAboutScreen
import com.example.foodcompose.features.main_app_feature.presentation.pages.screens.food_screen.FoodScreen
import com.example.foodcompose.features.main_app_feature.presentation.pages.screens.main_screen.MainScreen
import com.example.foodcompose.features.invoice_feature.presentation.pages.InvoiceFeaturePage
import com.example.foodcompose.features.main_app_feature.presentation.vmmv.MainAppFeatureViewModel

enum class AppScreenPath {
    MainScreen, FoodScreen, FoodAboutScreen, CartScreen,
}


@Composable
fun MainAppPage() {
    //

    //
    NavigationForMainAppPage()

}

@Composable
private fun NavigationForMainAppPage(
) {
    val navigationController = rememberNavController();

    val invoiceFeatureViewModel: InvoiceFeatureViewModel = hiltViewModel();

    val mainAppFeatureViewModel: MainAppFeatureViewModel = hiltViewModel();

    invoiceFeatureViewModel.initLocalDatabase(LocalContext.current)

    NavHost(
        navController = navigationController,
        startDestination = "destination_for_navigation" // you can name here anything you want (for navigation down below)
    ) {
        navigation(
            startDestination = AppScreenPath.MainScreen.name,
            route = "destination_for_navigation" // you can name here anything you want (for NavHost above)
        ) {

            composable(route = AppScreenPath.MainScreen.name) {
                MainScreen(
                    navigationController = navigationController,
                    viewModel = mainAppFeatureViewModel,
                    invoiceDetailsViewModel = invoiceFeatureViewModel,
                )
            }
            composable(route = AppScreenPath.FoodScreen.name) {
                FoodScreen(
                    navHostController = navigationController,
                    mainAppFeatureViewModel = mainAppFeatureViewModel,
                    invoiceFeatureViewModel,
                )
            }
            composable(route = AppScreenPath.FoodAboutScreen.name) {
                FoodAboutScreen(
                    navHostController = navigationController,
                    invoiceFeatureViewModel = invoiceFeatureViewModel,
                    mainAppFeatureViewModel = mainAppFeatureViewModel
                )
            }
            composable(route = AppScreenPath.CartScreen.name) {
                InvoiceFeaturePage(
                    navHostController = navigationController,
                    invoiceFeatureViewModel
                )
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    navController: NavController,
): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel();
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute);
    }
    return viewModel(parentEntry);
}

