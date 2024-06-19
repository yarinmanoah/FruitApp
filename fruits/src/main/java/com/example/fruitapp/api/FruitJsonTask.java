package com.example.fruitapp.api;

import com.example.food.entities.Food;
import com.example.food.OnFoodReadyCallback;

import java.io.IOException;
import java.util.List;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class FruitJsonTask {

     private OnFoodReadyCallback callback;
     public FruitJsonTask(OnFoodReadyCallback callback) {
         this.callback = callback;
     }
     public void execute() {
         Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl("https://www.fruityvice.com/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();

         FruitService service = retrofit.create(FruitService.class);
         service.getFruits().enqueue(new Callback<List<Food>>() {
             @Override
             public void onResponse(Response<List<Food>> response) {
                 List<Food> list = response.body();
                 if(response.isSuccess() && list != null)
                     callback.onFoodsReadSuccess(list);
                 else {
                     System.out.println(response.raw());
                     callback.onFoodsReadFailed(new IOException(response.message()));
                 }
                 callback = null;
             }

             @Override
             public void onFailure(Throwable t) {
                 t.printStackTrace();
                 callback.onFoodsReadFailed(new IOException(t.getMessage()));
             }
         });
     }

}
