package com.example.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.viewpager2.adapter.ImageSliderAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 sliderImageViewPager;
    private ArrayList<String> images = new ArrayList<>();
    private LinearLayout layoutIndicatorsContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images.add("https://cdn.pixabay.com/photo/2022/05/20/13/29/dogs-7209506__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/05/21/10/17/beach-7211174__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2013/05/09/09/06/waves-circles-109964__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/05/16/18/17/sheep-7200918__340.jpg");
        images.add("https://cdn.pixabay.com/photo/2022/05/14/12/38/oriental-garden-lizard-7195594__340.jpg");

        layoutIndicatorsContainer = findViewById(R.id.layoutIndicators);

        sliderImageViewPager = findViewById(R.id.sliderViewPager2);
        // 기본 default 값이 1. 2개를 먼저 올릴거라고 지정 -> 이미지가 제때 안뜨는 것을 방지
        sliderImageViewPager.setOffscreenPageLimit(2);
        sliderImageViewPager.setAdapter(new ImageSliderAdapter(this, images));
        sliderImageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
                Log.d("TAG", "position : " + position);
            }
        });

        setUpIndicators(images.size());

    }// end of onCreate


    private void setUpIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        // LayoutParams : 뷰가 어떻게 배치될 지 정의하는 속성(margin, wrap 등)
        // xml 파일에서 layout 붙는 속성들을 말한다.
        // layoutParams 객체를 통해서 다룰 수 있다.

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));
            // indicators[i] --> imageView Object
            indicators[i].setLayoutParams(params); //params의 속성을 가진 이미지뷰가 생성된 것.

            layoutIndicatorsContainer.addView(indicators[i]);
        }

    }// end of setUpIndicators

    private void setCurrentIndicator(int position) {
        // 몇개의 뷰가 있는지 뽑아낼 수 있음.
        int childCount = layoutIndicatorsContainer.getChildCount();

        for(int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicatorsContainer.getChildAt(i); // 다운캐스팅
            if(i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_active));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.bg_indicator_inactive));
            }
        }
    }

}