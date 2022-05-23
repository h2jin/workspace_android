package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout heightEt;
    TextInputLayout weightEt;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEt = findViewById(R.id.heightEt);
        weightEt = findViewById(R.id.weightEt);
        btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(view -> {
//            코드 리펙토링
            Editable heightEditable = heightEt.getEditText().getText();
            Editable weightEditable = weightEt.getEditText().getText();

            if (heightEditable.length() < 1 || weightEditable.length() < 1) {
                Toast.makeText(this, "빈 값이 있습니다", Toast.LENGTH_SHORT).show();
                return;
            }
//            int로 처리

            // 문자로 입력한 경우, 어플이 뻗지 않게 예외처리 해줄것!
//           혹은 xml 파일에서 inputType을 number로 해주기 -> 숫자만 입력할 수 있도록
            try {
                int height = Integer.parseInt(heightEditable.toString());
                int weight = Integer.parseInt(weightEditable.toString());

                Intent intent = new Intent(this, BmiResultActivity.class);
                intent.putExtra("height", height);
                intent.putExtra("weight", weight);
                startActivity(intent);


            } catch (NumberFormatException e) {
                Toast.makeText(this, "잘못 입력하셨습니다.", Toast.LENGTH_SHORT).show();
            }


        });

    }
}