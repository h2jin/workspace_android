package com.example.myretrofit2.repository.service;

import com.example.myretrofit2.repository.models.Post;
import com.example.myretrofit2.repository.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {

    // https://jsonplaceholder.typicode.com/todos
    @GET("todos")
    Call<ArrayList<Todo>> getTodos();

    // 하나의 데이터 오브젝트만 조회
    // https://jsonplaceholder.typicode.com/todos/22
    @GET("todos/{id}")
    Call<Todo> getTodo(@Path("id") int id);

    /**
     * {
     *     "userId": 1,
     *     "id": 1,
     *     "title": "delectus aut autem",
     *     "completed": false
     *   }
     *
     *
     * @return
     */
    //  모바일 -> 서버에 내 정보를 데이터 베이스에 입력 요청할 때 사용
    // https://jsonplaceholder.typicode.com/todos/posts
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("id") int id,
            @Field("title") String title,
            @Field("body") String body
    );
    
    



}
