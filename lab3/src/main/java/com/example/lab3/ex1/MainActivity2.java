package com.example.lab3.ex1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3.R;
import com.example.lab3.databinding.ActivityMain2Binding;


public class MainActivity2 extends AppCompatActivity {
//    ActivityMain2Binding binding;
    final static String KEY_EMAIL = "email";

    TextView textView , textView1;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityMain2Binding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
        setContentView(R.layout.activity_main_2);

        textView = findViewById(R.id.tvB);
        button = findViewById(R.id.btnB);
        textView1 = findViewById(R.id.textView2);

        Intent intent = getIntent();
        textView1.setText("Xin chào ," + intent.getStringExtra(MainActivity.Key_Name) + ".Vui lòng nhập tên")  ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.putExtra(KEY_EMAIL, textView.getText().toString());
                setResult(Activity.RESULT_OK, intent1);
                finish();
            }
        });
    }
}