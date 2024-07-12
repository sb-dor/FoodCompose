package com.example.foodcompose.features.invoice_feature.presentation.mvvm

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import com.example.foodcompose.core.database.LocalDatabase
import com.example.foodcompose.core.domain.entities.PizzaEntity
import com.example.foodcompose.features.invoice_feature.data.models.InvoiceDetailModel
import com.example.foodcompose.features.invoice_feature.domain.entities.InvoiceDetailEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class InvoiceFeatureViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(InvoiceFeatureModel())
    val uiState: StateFlow<InvoiceFeatureModel> = _uiState.asStateFlow()
    private var database: LocalDatabase? = null


    init {
        CoroutineScope(Dispatchers.Main).launch {
            val data = database?.getInvoiceDetailDao()?.getAllLocalInvoiceDetails();
            for (each in (data ?: emptyList())) {
                uiState.value.invoiceDetails.add(InvoiceDetailModel.fromLocalTable(invoiceDbEntity = each)!!);
            }
            _uiState.update { currentState ->
                currentState.copy(invoiceDetails = uiState.value.invoiceDetails)
            }
        }
    }

    fun initLocalDatabase(context: Context) {
        database = LocalDatabase.getDatabase(context);
    }

    fun addProductToInvoiceDetail(pizza: PizzaEntity? = null) {


        val tempList = uiState.value.invoiceDetails

        val element = tempList.firstOrNull { e -> e.pizza?.id == pizza?.id };

        if (element == null) {
            val invoiceDetail = InvoiceDetailEntity(
                pizza = pizza, qty = 1.0, price = pizza?.price
            );

            tempList.add(
                invoiceDetail
            )

            var toTable = InvoiceDetailModel.fromEntity(invoiceDetail)?.toLocalTable()

            if (toTable != null) CoroutineScope(Dispatchers.Main).launch {
                toTable.qty = 1.0;
                database?.getInvoiceDetailDao()?.insertLocalInvoiceDetail(toTable)
            }

        } else {
            // in order to update something you have to use copy with or clone that entity
            val changingElement = InvoiceDetailModel.fromEntity(element)!!.copyWith();
            element.qty = (element.qty ?: 0.0) + 1;
            tempList[tempList.indexOfFirst { e -> e.pizza?.id == element.pizza?.id }] =
                changingElement

            CoroutineScope(Dispatchers.Main).launch {
                changingElement.qty = element.qty;
                database?.getInvoiceDetailDao()?.updateLocalInvoiceDetail(
                    productId = changingElement.pizza?.id, qty = changingElement.qty
                )
            }

        }

        _uiState.update { currentState ->
            currentState.copy(
                invoiceDetails = tempList
            )
        }
    }

    fun removeProductItem(pizza: PizzaEntity? = null) {
        val tempList = uiState.value.invoiceDetails

        val element = tempList.firstOrNull { e -> e.pizza?.id == pizza?.id } ?: return

        element.qty = (element.qty ?: 0.0) - 1.0;

        if ((element.qty ?: 0.0) <= 0.0) {
            tempList.removeAll { e -> e.pizza?.id == element.pizza?.id }

            CoroutineScope(Dispatchers.Main).launch {
                database?.getInvoiceDetailDao()?.removeFromInvoice(
                    productId = element.pizza?.id ?: 0,
                )
            }

        } else {

            val changingElement = InvoiceDetailModel.fromEntity(element)!!.copyWith()

            tempList[tempList.indexOfFirst { e -> e.pizza?.id == element.pizza?.id }] =
                changingElement;

            CoroutineScope(Dispatchers.Main).launch {
                changingElement.qty = element.qty;
                database?.getInvoiceDetailDao()?.updateLocalInvoiceDetail(
                    productId = changingElement.pizza?.id, qty = changingElement.qty
                )
            }
        }

        _uiState.update { currentState -> currentState.copy(invoiceDetails = tempList) }
    }

    fun findPizza(pizza: PizzaEntity? = null): InvoiceDetailModel? {
        val element = _uiState.value.invoiceDetails.firstOrNull { e -> e.pizza?.id == pizza?.id }
            ?: return null;
        return InvoiceDetailModel.fromEntity(element);
    }


}