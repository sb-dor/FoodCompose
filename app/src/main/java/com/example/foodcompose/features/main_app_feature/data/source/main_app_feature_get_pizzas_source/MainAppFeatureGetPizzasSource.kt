package com.example.foodcompose.features.main_app_feature.data.source.main_app_feature_get_pizzas_source

import com.example.foodcompose.core.data.models.PizzaModel

interface MainAppFeatureGetPizzasSource {
    suspend fun listOfPizzas(): List<PizzaModel>;
}