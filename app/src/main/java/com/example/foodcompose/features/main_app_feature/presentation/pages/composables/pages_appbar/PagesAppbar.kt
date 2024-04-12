package com.example.foodcompose.features.main_app_feature.presentation.pages.composables.pages_appbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodcompose.features.invoice_feature.presentation.mvvm.InvoiceFeatureViewModel
import com.example.foodcompose.features.main_app_feature.presentation.pages.AppScreenPath

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagesAppTopBar(
    viewModel: InvoiceFeatureViewModel,
    navigationController: NavHostController,
    showNavigateBack: Boolean = false
) {
    val cartState by viewModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 15.dp)
    ) {
        Row {

            if (showNavigateBack)
                Row {
                    IconButton(onClick = { navigationController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                }

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
                IconButton(onClick = {

                    navigationController.navigate(AppScreenPath.CartScreen.name)

                }) {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = "Menu Desc",
                        modifier = Modifier.size(30.dp)
                    )
                }
                if (cartState.invoiceDetails.isNotEmpty()) {
                    Badge {
                        Text(
                            text = "${cartState.invoiceDetails.size}", color = Color.White
                        )
                    }
                }
            }
        }
    }
}
