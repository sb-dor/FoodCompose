package com.example.foodcompose.features.main_app_feature.domain.usecases.get_pizzas_usecase

import com.example.foodcompose.core.data.models.PizzaModel
import com.example.foodcompose.features.main_app_feature.data.repo.MainAppFeatureRepoImpl
import com.example.foodcompose.features.main_app_feature.domain.repo.MainAppFeatureRepo

class GetPizzaUseCase(private var mainAppFeatureRepo: MainAppFeatureRepo) {


    suspend fun getPizzas(): List<PizzaModel> {
        return mainAppFeatureRepo.listOfPizzas();
    }
}