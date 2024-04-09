package com.example.foodcompose.features.main_app_feature.presentation.vmmv

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.foodcompose.core.data.models.PizzaModel

data class MainAppFeatureModel(
    val listOfPizza: List<PizzaModel> = emptyList(),
    val loadingApi: Boolean = false,
    val tempPizzaModel: PizzaModel? = null
)