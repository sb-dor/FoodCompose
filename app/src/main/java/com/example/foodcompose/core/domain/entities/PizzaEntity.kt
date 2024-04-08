package com.example.foodcompose.core.domain.entities

open class PizzaEntity(
    cName: String? = null,
    cIngredients: List<String> = emptyList(),
    cDescription: String? = null,
    cPrice: Double? = null,
    cCalories: Double? = null,
    cProtein: Double? = null,
    cFat: Double? = null,
    cCarbs: Double? = null,
    cImage: String? = null,
) {
    val name: String? = cName
    val ingredients: List<String> = cIngredients
    val description: String? = cDescription
    val price: Double? = cPrice
    val calories: Double? = cCalories
    val protein: Double? = cProtein
    val fat: Double? = cFat
    val carbs: Double? = cCarbs
    val image: String? = cImage
}