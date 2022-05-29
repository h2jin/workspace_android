package com.example.mycarrot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;

import com.example.mycarrot.models.SettingList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView userImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SettingAdapter settingAdapter = new SettingAdapter(SettingList.getSettingData(), this);

        ArrayList<SettingList> lists = SettingList.getSettingData();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(settingAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        initData();
    }

    private void initData() {
        Toolbar toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tool_bar, menu);
        return true;
    }


}