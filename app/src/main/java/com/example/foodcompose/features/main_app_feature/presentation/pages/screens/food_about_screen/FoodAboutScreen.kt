package com.example.foodcompose.features.main_app_feature.presentation.pages.screens.food_about_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.foodcompose.core.components.AutoSizeText
import com.example.foodcompose.features.invoice_feature.presentation.mvvm.InvoiceFeatureViewModel
import com.example.foodcompose.features.main_app_feature.presentation.vmmv.MainAppFeatureViewModel
import com.example.foodcompose.ui.theme.amber


@Composable
fun FoodAboutScreen(
    navHostController: NavHostController,
    mainAppFeatureViewModel: MainAppFeatureViewModel,
    invoiceFeatureViewModel: InvoiceFeatureViewModel
) {

    val mainAppState by mainAppFeatureViewModel.uiCurrentState.collectAsState()
    val invoiceDetailState by invoiceFeatureViewModel.uiState.collectAsState()

    val findPizzaInCartList = invoiceFeatureViewModel.findPizza(mainAppState.tempPizzaModel)

    Scaffold(topBar = {
        IconButton(onClick = { navHostController.popBackStack() }) {
            Icon(Icons.Default.ArrowBack, contentDescription = null)
        }
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally),
                contentAlignment = Alignment.Center,
            ) {
                ImageLoader(imagePath = mainAppState.tempPizzaModel?.image)
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 15.dp, horizontal = 10.dp)
                    .background(color = Color.White),
                shadowElevation = 3.dp,
                shape = RoundedCornerShape(20.dp)
            ) {
                Column(modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp)) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Box(modifier = Modifier.weight(1f)) {
                            Text(
                                text = mainAppState.tempPizzaModel?.name ?: "",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        if (invoiceFeatureViewModel.findPizza(mainAppState.tempPizzaModel) == null) AutoSizeText(
                            text = "$${mainAppState.tempPizzaModel?.price}",
                            fontSize = 15.sp,
                            color = Color.Blue,
                            fontWeight = FontWeight.W600
                        )
                        else Row {
                            AutoSizeText(
                                text = "${findPizzaInCartList?.qty?.toInt()}" + "/$${findPizzaInCartList?.total()}",
                                fontSize = 15.sp,
                                color = Color.Blue,
                                fontWeight = FontWeight.W600
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            shadowElevation = 5.dp,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(1f)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp),
                            ) {
                                Icon(
                                    Icons.Default.AddCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = "${mainAppState.tempPizzaModel?.calories} Calories",
                                    fontSize = 8.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            shadowElevation = 5.dp,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(1f)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp),
                            ) {
                                Icon(
                                    Icons.Default.AddCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = "${mainAppState.tempPizzaModel?.protein} Protein",
                                    fontSize = 8.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            shadowElevation = 5.dp,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(1f)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp),
                            ) {
                                Icon(
                                    Icons.Default.AddCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = "${mainAppState.tempPizzaModel?.fat} Far",
                                    fontSize = 8.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            shadowElevation = 5.dp,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(1f)
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp),
                            ) {
                                Icon(
                                    Icons.Default.AddCircle,
                                    contentDescription = null,
                                    modifier = Modifier.size(20.dp)
                                )
                                Text(
                                    text = "${mainAppState.tempPizzaModel?.carbs} Carbs",
                                    fontSize = 8.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                    
                    Divider(thickness = 1.dp, color = Color.Gray, modifier = Modifier.height(10.dp))
                    Row {
                        Box(modifier = Modifier.weight(1f)){
                            Text(text = "Make Yours")
                        }
                    }
                    
                    Spacer(modifier = Modifier.weight(1f))
                    ElevatedButton(
                        onClick = {
                            invoiceFeatureViewModel.addProductToInvoiceDetail(
                                mainAppState.tempPizzaModel
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = amber)
                    ) {
                        Text(
                            text = "By now", color = Color.White
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ImageLoader(imagePath: String? = null) {
    AsyncImage(
        model = imagePath,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}