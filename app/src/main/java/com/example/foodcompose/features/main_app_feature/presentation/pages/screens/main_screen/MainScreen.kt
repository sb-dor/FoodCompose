package com.example.foodcompose.features.main_app_feature.presentation.pages.screens.main_screen

import android.util.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodcompose.R
import com.example.foodcompose.features.main_app_feature.presentation.vmmv.MainAppFeatureViewModel
import androidx.lifecycle.viewmodel.compose.viewModel;
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
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
                    .height(150.dp)
                    .fillMaxWidth()
            ) {
                LazyRow {
                    itemsIndexed(mainAppFeatureState.listOfPizza) { index, item ->
                        Box(
                            modifier = Modifier
                                .height(150.dp)
                                .width(150.dp)
                        ) {
                            LoadImageFromInternet(item.image)
                        }
                        if (index < mainAppFeatureState.listOfPizza.size - 1) {
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
            ) {
//                LoadImageFromInternet("https://github.com/sb-dor/FoodCompose/blob/master/app/src/main/res/drawable-nodpi/_2.png")

                GlideImage(
                    model = "https://raw.githubusercontent.com/sb-dor/FoodCompose/dc09efd77499c75469cfe1a360ccbe257fd80466/app/src/main/res/drawable-nodpi/_2.png",
                    contentDescription = "",
                )
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