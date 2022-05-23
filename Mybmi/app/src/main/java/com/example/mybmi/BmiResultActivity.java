package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BmiResultActivity extends AppCompatActivity {

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        resultTextView = findViewById(R.id.bmiResultView);

        if (getIntent() != null) {

            int height = getIntent().getIntExtra("height", 0);
            int weight = getIntent().getIntExtra("weight", 0);

//            BMI 공식 체중 /신장(m) *신장
//            나누기를 계산할 떄는 소수점을 써주기!
            double bmiValue = weight / Math.pow(height / 100.0, 2);
            Log.d("TAG", bmiValue + "");
            String resultText = "";
            if (bmiValue < 18.5) {
                resultText = "저체중입니다.";
            } else if (bmiValue < 23) {
                resultText = "정상체중입니다.";
            } else if (bmiValue < 25) {
                resultText = "과체중입니다.";
            } else if (bmiValue < 30.0) {
                resultText = "경도 비만입니다.(1단계 비만)";
            } else if (bmiValue < 35) {
                resultText = "고도비만입니다.(2단계 비만)";
            } else {
                resultText = "초고도비만입니다.(3단계 비만)";
            }

            resultTextView.setText(resultText);

        }

    }
}