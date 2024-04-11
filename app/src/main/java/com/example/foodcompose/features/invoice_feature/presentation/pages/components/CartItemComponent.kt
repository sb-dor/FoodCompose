package com.example.foodcompose.features.invoice_feature.presentation.pages.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodcompose.features.invoice_feature.data.models.InvoiceDetailModel
import com.example.foodcompose.features.invoice_feature.domain.entities.InvoiceDetailEntity
import com.example.foodcompose.features.invoice_feature.presentation.mvvm.InvoiceFeatureViewModel


@Composable
fun CartItemComponent(
    item: InvoiceDetailEntity? = null,
    invoiceDetailsViewModel: InvoiceFeatureViewModel
) {

    val model = InvoiceDetailModel.fromEntity(item);

    Box(modifier = Modifier.fillMaxWidth()) {
        Row {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .padding(horizontal = 10.dp)
            ) {
                LoadImageFromInternet(item?.pizza?.image)
            }
            Spacer(modifier = Modifier.width(15.dp))
            Box(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Row {
                        Box(modifier = Modifier.weight(1f)) {
                            Text(text = "${model?.pizza?.name}", fontWeight = FontWeight.Bold)
                        }
                        Text(text = "${model?.total()}")
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "${model?.pizza?.description}",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        lineHeight = 15.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Surface(
                        modifier = Modifier.padding(horizontal = 3.dp, vertical = 3.dp),
                        shape = RoundedCornerShape(15.dp),
                        shadowElevation = 1.dp
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(Icons.Rounded.Delete, contentDescription = null)
                            }
                            Text(text = "${model?.qty?.toInt()}")
                            IconButton(onClick = {
                                invoiceDetailsViewModel.addProductToInvoiceDetail(item?.pizza)
                            }) {
                                Icon(Icons.Rounded.Add, contentDescription = null)
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.width(15.dp))
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