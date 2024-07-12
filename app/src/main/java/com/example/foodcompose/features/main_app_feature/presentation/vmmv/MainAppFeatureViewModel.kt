package com.example.foodcompose.features.main_app_feature.presentation.vmmv

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.foodcompose.core.data.models.PizzaModel
import com.example.foodcompose.core.domain.entities.PizzaEntity
import com.example.foodcompose.features.main_app_feature.data.repo.MainAppFeatureRepoImpl
import com.example.foodcompose.features.main_app_feature.domain.repo.MainAppFeatureRepo
import com.example.foodcompose.features.main_app_feature.domain.usecases.get_pizzas_usecase.GetPizzaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MainAppFeatureViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private lateinit var mainAppFeatureRepo: MainAppFeatureRepo;
    private var getPizzaUsecase: GetPizzaUseCase

    //
    private val _currentState = MutableStateFlow(MainAppFeatureModel())
    val uiCurrentState: StateFlow<MainAppFeatureModel> = _currentState.asStateFlow()


    init {
        mainAppFeatureRepo = MainAppFeatureRepoImpl();
        getPizzaUsecase = GetPizzaUseCase(mainAppFeatureRepo);

        CoroutineScope(Dispatchers.Main).launch {
            loadDataFromApi()
        }
    }


    private suspend fun loadDataFromApi() {
        _currentState.update {
            uiCurrentState.value.copy(loadingApi = true)
        }

        val getPizzas = getPizzaUsecase.getPizzas();
        println("made request for getting pizza: $getPizzas")
        _currentState.update {
            uiCurrentState.value.copy(
                listOfPizza = getPizzas, loadingApi = false
            )
        }

    }

    fun initTempPizzaForAboutScreen(pizza: PizzaEntity) {
        _currentState.update { currentState ->
            currentState.copy(tempPizzaModel = PizzaModel.fromEntity(pizza))
        }
    }
}
