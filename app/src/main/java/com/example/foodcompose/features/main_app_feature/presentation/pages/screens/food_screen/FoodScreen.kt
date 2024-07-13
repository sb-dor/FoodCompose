package com.example.foodcompose.features.main_app_feature.presentation.pages.screens.food_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.foodcompose.features.invoice_feature.presentation.mvvm.InvoiceFeatureViewModel
import com.example.foodcompose.features.main_app_feature.presentation.pages.composables.MainScreenPizzaLoadedComponent
import com.example.foodcompose.features.main_app_feature.presentation.pages.composables.pages_appbar.PagesAppTopBar
import com.example.foodcompose.features.main_app_feature.presentation.vmmv.MainAppFeatureViewModel

@Composable
fun FoodScreen(
    navHostController: NavHostController,
    mainAppFeatureViewModel: MainAppFeatureViewModel,
    invoiceFeatureViewModel: InvoiceFeatureViewModel,
) {


    val mainAppFeatureViewModelState by mainAppFeatureViewModel.uiCurrentState.collectAsState();

    Column {
        PagesAppTopBar(
            viewModel = invoiceFeatureViewModel,
            navigationController = navHostController,
            showNavigateBack = true
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 10.dp, end = 10.dp)
        ) {
            itemsIndexed(mainAppFeatureViewModelState.listOfPizza) { _, item ->
                MainScreenPizzaLoadedComponent(
                    item = item,
                    invoiceDetailsViewModel = invoiceFeatureViewModel,
                    navHostController = navHostController,
                    mainAppFeatureViewModel = mainAppFeatureViewModel
                )
            }
        }

    }

}