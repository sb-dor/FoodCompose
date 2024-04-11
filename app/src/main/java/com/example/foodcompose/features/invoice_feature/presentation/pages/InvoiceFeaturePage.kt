package com.example.foodcompose.features.invoice_feature.presentation.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.foodcompose.features.invoice_feature.presentation.mvvm.InvoiceFeatureViewModel
import com.example.foodcompose.features.invoice_feature.presentation.pages.components.CartItemComponent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvoiceFeaturePage(
    navHostController: NavHostController, invoiceViewModel: InvoiceFeatureViewModel
) {

    val invoiceCartState by invoiceViewModel.uiState.collectAsState();

    Scaffold(topBar = {
        InvoiceFeaturePageAppBar(navHostController)
    }) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            itemsIndexed(invoiceCartState.invoiceDetails) { index, item ->
                CartItemComponent(item = item, invoiceViewModel)
                if (index < invoiceCartState.invoiceDetails.size - 1) Spacer(
                    modifier = Modifier.height(10.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvoiceFeaturePageAppBar(navHostController: NavHostController) {
    CenterAlignedTopAppBar(

        title = { Text("Your Cart") }, navigationIcon = {
            IconButton(onClick = { navHostController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        })
}