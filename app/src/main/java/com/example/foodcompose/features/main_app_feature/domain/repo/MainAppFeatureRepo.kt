package com.example.foodcompose.features.main_app_feature.domain.repo

import com.example.foodcompose.core.data.models.PizzaModel

interface MainAppFeatureRepo {
    suspend fun listOfPizzas(): List<PizzaModel>;
}