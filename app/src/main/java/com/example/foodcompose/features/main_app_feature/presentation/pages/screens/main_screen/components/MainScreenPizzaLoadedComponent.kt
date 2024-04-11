package com.example.foodcompose.features.main_app_feature.presentation.pages.screens.main_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.annotation.ExperimentalCoilApi
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodcompose.core.domain.entities.PizzaEntity
import com.example.foodcompose.features.invoice_feature.presentation.mvvm.InvoiceFeatureViewModel

@Composable
fun MainScreenPizzaLoadedComponent(
    item: PizzaEntity, invoiceDetailsViewModel: InvoiceFeatureViewModel,
) {

    val currentStateInvoiceViewModelState by invoiceDetailsViewModel.uiState.collectAsState();

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp, horizontal = 5.dp)
            .width(150.dp),
        shape = RoundedCornerShape(
            topStart = 100.dp, topEnd = 100.dp, bottomEnd = 15.dp, bottomStart = 15.dp
        ),
        shadowElevation = 8.dp,
    ) {
        Column(
            modifier = Modifier.padding(
                start = 10.dp, end = 10.dp
            )
        ) {
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
            ) {
                LoadImageFromInternet(item.image)
            }
            Text(
                text = "${item.name}", fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = "${item.description}",
                fontSize = 10.sp,
                fontWeight = FontWeight.W300,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Gray,
                lineHeight = 10.sp
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(horizontalArrangement = Arrangement.Center) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = "$${item.price}",
                        fontSize = 15.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.W600
                    )
                }
                IconButton(onClick = { invoiceDetailsViewModel.addProductToInvoiceDetail(item) }) {
                    Icon(Icons.Rounded.Add, contentDescription = null)
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun LoadImageFromInternet(imageUrl: String?) {
    GlideImage(
        model = imageUrl,
        contentDescription = "",
    )

}