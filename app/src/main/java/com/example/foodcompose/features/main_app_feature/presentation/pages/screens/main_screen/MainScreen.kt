package com.example.foodcompose.features.main_app_feature.presentation.pages.screens.main_screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.foodcompose.R
import com.example.foodcompose.features.main_app_feature.presentation.vmmv.MainAppFeatureViewModel
import androidx.lifecycle.viewmodel.compose.viewModel;

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
        }
    }
}