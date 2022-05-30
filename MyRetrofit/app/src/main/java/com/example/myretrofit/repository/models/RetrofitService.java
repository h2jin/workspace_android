package com.example.myretrofit.repository.models;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

//    https://jsonplaceholder.typicode.com/todos/
    @GET("todos")
//    리스트로 받기 때문에 배열로
    Call<ArrayList<Todo>> getTodos();


}
