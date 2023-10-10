package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity_ex3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        Log.d("MyApp", "Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MyApp", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MyApp", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MyApp", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MyApp", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MyApp", "onDestroy");
    }
}