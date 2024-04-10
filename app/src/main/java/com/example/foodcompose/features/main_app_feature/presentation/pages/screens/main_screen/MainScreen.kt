package com.example.foodcompose.features.main_app_feature.presentation.pages.screens.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodcompose.R
import com.example.foodcompose.features.main_app_feature.presentation.vmmv.MainAppFeatureViewModel
import androidx.lifecycle.viewmodel.compose.viewModel;
import coil.annotation.ExperimentalCoilApi
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MainScreen(
    paddingValues: PaddingValues,
    navigationController: NavHostController,
    viewModel: MainAppFeatureViewModel = viewModel()
) {

    val mainAppFeatureState by viewModel.uiCurrentState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 10.dp)
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
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.TopStart)
                                .padding(vertical = 10.dp, horizontal = 5.dp)
                                .width(150.dp),
                            shape = RoundedCornerShape(
                                topStart = 100.dp,
                                topEnd = 100.dp,
                                bottomEnd = 15.dp,
                                bottomStart = 15.dp
                            ),
                            shadowElevation = 8.dp,

                            ) {
                            Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
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
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(Icons.Rounded.Add, contentDescription = null)
                                    }
                                }
                            }
                        }
                        if (index < mainAppFeatureState.listOfPizza.size - 1) {
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
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