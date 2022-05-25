package com.example.myglide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

//        프로젝트에 있는 이미지들을 라운드 처리하는 라이브러리를 사용해서
//        circleCrop 처리를 한다면 사용할 수 없다.
//        글라이드와 피카소 많이 씀. 기능은 글라이드가 좀 더 많다.

    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageView1 = findViewById(R.id.gImageView1);
        imageView2 = findViewById(R.id.gImageView2);
        imageView3 = findViewById(R.id.gImageView3);
        imageView4 = findViewById(R.id.gImageView4);
        imageView5 = findViewById(R.id.gImageView5);
        imageView6 = findViewById(R.id.gImageView6);

//        6개 이미지에 (인물 사진) 그리기

        Glide.with(this).load("https://search.pstatic.net/common?type=f&size=174x196&quality=75&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202012%2F20201207192857469.jpg")
                .circleCrop().into(imageView1);
        Glide.with(this).load("https://search.pstatic.net/common?type=f&size=174x196&quality=75&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202010%2F20201008145307583.jpg").circleCrop().into(imageView2);
        Glide.with(this).load("https://search.pstatic.net/common?type=f&size=174x196&quality=75&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201907%2F20190704112907168.jpg").circleCrop().into(imageView3);
        Glide.with(this).load("https://search.pstatic.net/common?type=f&size=174x196&quality=75&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F189%2F202204291033491471.jpg").circleCrop().into(imageView4);
        Glide.with(this).load("https://search.pstatic.net/common?type=f&size=174x196&quality=75&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202004%2F20200406133740398.jpg").circleCrop().into(imageView5);
        Glide.with(this).load("https://search.pstatic.net/common?type=f&size=174x196&quality=75&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201911%2F20191101112904972.jpg").circleCrop().into(imageView6);

//        https://picsum.photos/200/300?random=1 -> 랜덤으로 이미지를 뽑을 수 있음.
//        위를 이용하여 나중에 랜덤이미지를 뽑을 때 활용할 수 있을 것!


    }
}