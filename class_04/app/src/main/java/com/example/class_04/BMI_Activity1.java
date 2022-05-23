package com.example.class_04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class BMI_Activity1 extends AppCompatActivity {

    private Button resultBtn;
    private EditText height;
    private EditText weight;
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_WEIGHT = "weight";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi1);
        initData();
        addActionListener();
    }

    private void initData() {
        resultBtn = findViewById(R.id.resultBtn);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
    }

    private void addActionListener() {
        resultBtn.setOnClickListener(view -> {

            String heightValue = height.getText().toString();
            String weightValue = weight.getText().toString();

            Intent intent = new Intent(this, BMI_Activity2.class);
            intent.putExtra(KEY_HEIGHT, heightValue);
            intent.putExtra(KEY_WEIGHT, weightValue);

            startActivity(intent);
        });
    }

}