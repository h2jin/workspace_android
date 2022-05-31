package com.example.myretrofit3.service;

import com.example.myretrofit3.models.reponse.ResponsePostDto;
import com.example.myretrofit3.models.request.ReqPostDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

// https://jsonplaceholder.typicode.com/  -> 마지막 슬러시 꼭 넣어주기! 오류 확인도 잘 안됨.
// 서비스 로직 짜기
public interface JPHService {

//    레트로핏 초기화
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create()).build();

//    https://jsonplaceholder.typicode.com/posts/{id} -> 하나의 응답값을 받음
    @GET("posts/{id}")
    Call<ResponsePostDto> post(@Path("id") int id);

//    https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<ResponsePostDto>> postList();

//    https://jsonplaceholder.typicode.com/posts/{id}
//    HTTP 메세지 body 부분에 데이터를 넣어서 서버에 전달한다. (MINE TYPE : JSON) 서버에서 이미 약속해놓음.
//    우리의 데이터가 잘 전달 되었다면 서버에서는 응답 값을 보내준다.
//    값을 보낼 때 어떻게 데이터를 보낼 지 설계해야 한다.
    @POST("posts")
    Call<ResponsePostDto> createPost(@Body ReqPostDto reqPostDto);

    @PUT("posts/{PostId}")
    Call<ResponsePostDto> updatePost(@Path("PostId")int postId, @Body ReqPostDto reqPostDto);
    
//    path-variable 방식
    @DELETE("posts/{postId}")
    Call<Void> deletePost(@Path("postId") int postId);

//    @FormUrlEncoded
//    @GET("/posts")
//    Call<List<ResponsePostDto>> searchByUserId(@Field("userId") int userId);


}
