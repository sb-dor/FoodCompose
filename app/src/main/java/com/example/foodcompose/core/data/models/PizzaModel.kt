package com.example.foodcompose.core.data.models

import com.example.foodcompose.core.domain.entities.PizzaEntity

class PizzaModel(
    cId: Int? = null,
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
    cId = cId,
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


    // means like static fields in Dart
    companion object {
        fun fromJson(json: Map<String, Any>): PizzaModel {
            return PizzaModel(
                cId = (json["id"] as? Double?)?.toInt(),
                cName = json["name"] as? String?,
                cDescription = json["description"] as? String?,
                cPrice = json["price"] as? Double?,
                cCalories = json["calories"] as? Double?,
                cProtein = json["protein"] as? Double?,
                cFat = json["fat"] as? Double?,
                cCarbs = json["carbs"] as? Double,
                cImage = json["image"] as? String?
            );
        }
    }

}