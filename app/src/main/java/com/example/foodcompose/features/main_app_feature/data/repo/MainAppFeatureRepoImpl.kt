package com.example.foodcompose.features.main_app_feature.data.repo

import com.example.foodcompose.core.data.models.PizzaModel
import com.example.foodcompose.features.main_app_feature.data.source.main_app_feature_get_pizzas_source.MainAppFeatureGetPizzasSource
import com.example.foodcompose.features.main_app_feature.data.source.main_app_feature_get_pizzas_source.impl.MainAppFeatureGetPizzasSourceImpl
import com.example.foodcompose.features.main_app_feature.domain.repo.MainAppFeatureRepo

class MainAppFeatureRepoImpl : MainAppFeatureRepo {

    private var mainAppFeatureGetPizzasSource: MainAppFeatureGetPizzasSource =
        MainAppFeatureGetPizzasSourceImpl()

    override suspend fun listOfPizzas(): List<PizzaModel> {
        return mainAppFeatureGetPizzasSource.listOfPizzas();
    }
}