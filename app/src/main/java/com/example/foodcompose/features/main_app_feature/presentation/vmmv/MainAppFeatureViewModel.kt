package com.example.foodcompose.features.main_app_feature.presentation.vmmv

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.foodcompose.core.data.models.PizzaModel
import com.example.foodcompose.features.main_app_feature.data.repo.MainAppFeatureRepoImpl
import com.example.foodcompose.features.main_app_feature.domain.repo.MainAppFeatureRepo
import com.example.foodcompose.features.main_app_feature.domain.usecases.get_pizzas_usecase.GetPizzaUseCase
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.runBlocking

class MainAppFeatureViewModel : ViewModel() {
    private lateinit var mainAppFeatureRepo: MainAppFeatureRepo;
    private var getPizzaUsecase: GetPizzaUseCase

    //
    private val _currentState = MutableStateFlow(MainAppFeatureModel())
    val uiCurrentState: StateFlow<MainAppFeatureModel> = _currentState.asStateFlow()


    init {
        mainAppFeatureRepo = MainAppFeatureRepoImpl();
        getPizzaUsecase = GetPizzaUseCase(mainAppFeatureRepo);
    }

    private suspend fun loadDataFromApi() {
        _currentState.update {
            uiCurrentState.value.copy(loadingApi = true)
        }

        runBlocking {
            val getPizzas: Deferred<List<PizzaModel>> = async { getPizzaUsecase.getPizzas(); }
            val pizzas = getPizzas.await();
            _currentState.update {
                uiCurrentState.value.copy(
                    listOfPizza = pizzas,
                    loadingApi = false
                )
            }
        }

    }
}
