package com.example.myfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends Fragment {
    private static final String TAG = "TAG";
    
//    실행 흐름이 존재한다. -> 수명주기


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    public FragmentOne() {
        // Required empty public constructor
    }

    public static FragmentOne newInstance() {
        FragmentOne fragment = new FragmentOne();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate 호출");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView 호출");
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated 호출");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "onViewStateRestored 호출");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart 호출");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume 호출");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause 호출");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop 호출");
    }
}