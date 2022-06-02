package com.example.movie_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        TextView textView = findViewById(R.id.splashTextView);
        // 애니메이션
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_side);
        textView.startAnimation(slideAnimation);

        // 시간이 지나면 새로운 화면 띄움
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 동작 명시
                // getApplicationContext() 액티비티들의 전체 정보를 알고 있음.
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                // splashActivity --> MainActivity. 더이상 splash 필요 없으므로 finish 해서 내려줌
                finish();
                // MainActivity 만 남게 됨.
            }
        }, 1500);


    }
}