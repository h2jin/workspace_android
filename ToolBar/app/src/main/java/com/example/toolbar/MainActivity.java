package com.example.toolbar;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    // 값을 돌려 받고자 할 때 미리 만들어 줘야 한다.
    ActivityResultLauncher<Intent> startActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                Log.d("TAG", "comback");
                if(result.getResultCode() == Activity.RESULT_OK) {
                    // 정상 동작
                    Intent data = result.getData();
                    int returnValue = data.getIntExtra("result", 0);
                    textView.setText(returnValue + "");
                } else {
                    // 실패
                }
            }
    );

    // startActivityforresult
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        textView = findViewById(R.id.tempTextView);

    }

//    인플레이터 : 부풀리다. -> menu 에 만들었던 menu_toolbar 메모리에 올라가야 사용할 수 있다.
//    자바 코드에서 메모리에서 올리고자 할 때 인플레이터 씀

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        객체를 가지고 옴. 
        MenuInflater inflater = getMenuInflater();
//         동작을 시킴 . 메모리에 올리는 인플레이터 동작. menu -> 오브젝트를 넣어준 것
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    // 둘 다 return 값이 true 여야 함. 그래야 이벤트 리스너가 동작하게 됨.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem1:
                Intent intent = new Intent(this, SubActivity.class);
                intent.putExtra("value1", 10);
//                startActivity(intent); -> 값을 보낼 때
                // 값을 다시 받아야 할 때
                startActivityResult.launch(intent);

                break;
            case R.id.menuItem2:
                Log.d("TAG", "2번 클릭");
                break;
            case R.id.menuItem3:
                Log.d("TAG", "3번 클릭");
                break;
        }

        return true;
    }
}