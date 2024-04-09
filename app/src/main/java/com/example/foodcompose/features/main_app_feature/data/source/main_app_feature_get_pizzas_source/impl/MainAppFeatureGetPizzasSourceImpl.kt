package com.example.foodcompose.features.main_app_feature.data.source.main_app_feature_get_pizzas_source.impl

import com.example.foodcompose.core.data.models.PizzaModel
import com.example.foodcompose.features.main_app_feature.data.source.main_app_feature_get_pizzas_source.MainAppFeatureGetPizzasSource
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface PizzaApiService {

    @GET("master/pizza-json.json")
    suspend fun getPizzas(): Any

}

class MainAppFeatureGetPizzasSourceImpl : MainAppFeatureGetPizzasSource {
    override suspend fun listOfPizzas(): List<PizzaModel> {

        val list = mutableListOf<PizzaModel>();

        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/sb-dor/FoodCompose/")
                .addConverterFactory(GsonConverterFactory.create()).build();


            val pizzaApiService = retrofit.create(PizzaApiService::class.java)

            val response = pizzaApiService.getPizzas() as Map<*, *>

            val dynamicList: List<*>? = response["pizzas"] as? List<*>;

            for (n in (dynamicList ?: emptyList<PizzaModel>())) {
                list.add(PizzaModel.fromJson(n as Map<String, Any>));
            }

            println("getting response from server: dynamiclist is: $dynamicList | type: ${response::class.java} | $response")
        } catch (e: Exception) {
            println();
        }

        return list;
    }
}