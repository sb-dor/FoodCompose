package com.example.foodcompose.core.data.models

import com.example.foodcompose.core.domain.entities.PizzaEntity

class PizzaModel(
    cName: String? = null,
    cIngredients: List<String> = emptyList(),
    cDescription: String? = null,
    cPrice: Double? = null,
    cCalories: Double? = null,
    cProtein: Double? = null,
    cFat: Double? = null,
    cCarbs: Double? = null,
    cImage: String? = null,
) : PizzaEntity(
    cName = cName,
    cIngredients = cIngredients,
    cDescription = cDescription,
    cPrice = cPrice,
    cCalories = cCalories,
    cProtein = cProtein,
    cFat = cFat,
    cCarbs = cCarbs,
    cImage = cImage,
) {
}