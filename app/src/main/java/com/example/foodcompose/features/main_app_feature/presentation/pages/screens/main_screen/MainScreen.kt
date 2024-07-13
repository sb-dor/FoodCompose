package com.example.foodcompose.features.main_app_feature.presentation.pages.screens.main_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.foodcompose.R
import com.example.foodcompose.features.main_app_feature.presentation.vmmv.MainAppFeatureViewModel
import androidx.lifecycle.viewmodel.compose.viewModel;
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.foodcompose.features.invoice_feature.presentation.mvvm.InvoiceFeatureViewModel
import com.example.foodcompose.features.main_app_feature.presentation.pages.AppScreenPath
import com.example.foodcompose.features.main_app_feature.presentation.pages.composables.MainScreenPizzaLoadedComponent
import com.example.foodcompose.features.main_app_feature.presentation.pages.composables.pages_appbar.PagesAppTopBar


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MainScreen(
    navigationController: NavHostController,
    viewModel: MainAppFeatureViewModel,
    invoiceDetailsViewModel: InvoiceFeatureViewModel,
) {

    val mainAppFeatureState by viewModel.uiCurrentState.collectAsState()


    Column(modifier = Modifier.fillMaxSize()) {

        PagesAppTopBar(invoiceDetailsViewModel, navigationController)

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 10.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        stringResource(R.string.pizza_main_scren_title),
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 40.sp,
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Box(
                        modifier = Modifier
//                    .height(160.dp)
                            .fillMaxWidth()
                    ) {
                        LazyRow {
                            itemsIndexed(mainAppFeatureState.listOfPizza) { index, item ->
                                MainScreenPizzaLoadedComponent(
                                    item,
                                    invoiceDetailsViewModel,
                                    navHostController = navigationController,
                                    mainAppFeatureViewModel = viewModel
                                )
                                if (index < mainAppFeatureState.listOfPizza.size - 1) {
                                    Spacer(modifier = Modifier.width(10.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
        TextButton(onClick = {

            navigationController.navigate(AppScreenPath.FoodScreen.name)

        }, modifier = Modifier.align(Alignment.End)) {
            Text(text = "View All ->", color = Color.Blue, fontSize = 16.sp)
        }
    }
}