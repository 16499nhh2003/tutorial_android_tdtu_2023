package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class activity_main_bai1 extends AppCompatActivity {
    Button btToast;
    Button btCount;
    TextView tvCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        btToast = findViewById(R.id.btToast);
        btCount = findViewById(R.id.btCount);
        tvCount = findViewById(R.id.tvCount);

        btCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = tvCount.getText().toString();
                int value = Integer.parseInt(currentValue);
                int newValue = value + 1;
                tvCount.setText(String.valueOf(newValue));
            }
        });

        btToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),tvCount.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }

}