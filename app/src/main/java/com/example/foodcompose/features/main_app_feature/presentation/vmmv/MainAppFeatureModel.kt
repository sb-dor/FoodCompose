package com.example.foodcompose.features.main_app_feature.presentation.vmmv

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.foodcompose.core.data.models.PizzaModel
import com.example.foodcompose.core.domain.entities.PizzaEntity

data class MainAppFeatureModel(
    val listOfPizza: List<PizzaEntity> = emptyList(),
    val loadingApi: Boolean = false,
    val tempPizzaModel: PizzaEntity? = null
)