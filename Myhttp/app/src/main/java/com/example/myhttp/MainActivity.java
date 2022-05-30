package com.example.myhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myhttp.models.Post;
import com.example.myhttp.models.Todo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        textView1 = findViewById(R.id.textView1);


//    오류가 난 이유
//    안드로이드는 하나의 스레드가 기본이라서 통신을 하려면 스레드를 만들어줘야 한다.

//        람다식으로 변경 Runnable은 run메서드만 가지고있기 때문
        new Thread(() -> {
            httpGetTest();
        }).start();

//        try {
//        } catch (NetworkOnMainThreadException e) {
//            Toast.makeText(this, "에러가 발생", Toast.LENGTH_SHORT).show();
//        }


    }


    private void httpGetTest() {
//        jsonPlaceHorder -
//        https://jsonplaceholder.typicode.com/todos/1
        String urlString = "https://jsonplaceholder.typicode.com/posts";
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

//            참고
//            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                통신 성공
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(), "UTF-8"
                ));

//                1. 한 라인(한 줄)
//                reader.readLine();

//                String line = null;
//                StringBuffer sb = new StringBuffer();
//
//                while( (line = reader.readLine()) != null ) {
////                    BufferedReader는 라인 바꿔주는 기능 없음.
//                    sb.append(line + "\n");
//                }
//                Log.d("TAG", sb.toString());

//                dto 만들어야 함
//                문자열 -> 하나의 Object로 변환하는 방법
//                Todo todo1 = new Gson().fromJson(reader, Todo.class);
//                Log.d("TAG", todo1.title);

//                문자열 --> 배열 타입으로 변환하는 방법
//                Todo[] todos = new Gson().fromJson(reader, Todo[].class);
//                Log.d("TAG", todos.toString());

//                문자열 --> Arraylist 타입으로 변환하는 방법 -> 실질적으로 가장 많이 씀
//                Type todoListType = new TypeToken<ArrayList<Todo>>() {
//                }.getType();
//                ArrayList<Todo> todoList = new Gson().fromJson(reader, todoListType);
//
//                for(Todo t : todoList) {
//                    Log.d("TAG", t.userId + ": userId");
//                    Log.d("TAG", t.title + ": title");
//                }

                Type postListType = new TypeToken<ArrayList<Post>>() {
                }.getType();
                ArrayList<Post> posts = new Gson().fromJson(reader, postListType);


                btn1.setOnClickListener(view -> {
//                    textView1.setText(posts.get(0).getTitle());
                });


            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}