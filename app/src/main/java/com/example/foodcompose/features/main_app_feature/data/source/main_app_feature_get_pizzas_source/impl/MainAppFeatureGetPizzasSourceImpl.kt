package com.example.foodcompose.features.main_app_feature.data.source.main_app_feature_get_pizzas_source.impl

import com.example.foodcompose.core.data.models.PizzaModel
import com.example.foodcompose.features.main_app_feature.data.source.main_app_feature_get_pizzas_source.MainAppFeatureGetPizzasSource

class MainAppFeatureGetPizzasSourceImpl : MainAppFeatureGetPizzasSource {
    override suspend fun listOfPizzas(): List<PizzaModel> {
        return emptyList();
    }
}