package com.example.lab1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class activity_main_bai2 extends AppCompatActivity {
    private EditText etInfo;
    private Button btEnter;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        mapping();
        onClick();
    }

    private void mapping() {
        etInfo = findViewById(R.id.etInfo);
        btEnter = findViewById(R.id.btEnter);
        tvResult = findViewById(R.id.tvResult);
    }

    private void onClick() {
        btEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = etInfo.getText().toString().trim();
                if (currentValue.isEmpty()) {
                    Toast.makeText(activity_main_bai2.this, "vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    tvResult.setText(currentValue);
                    etInfo.getText().clear();
                }
            }
        });

        etInfo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String currentCmd = etInfo.getText().toString().trim().toUpperCase(Locale.ROOT);
                if (currentCmd.equals("OFF")) {
                    btEnter.setEnabled(false);
                }
                if (currentCmd.equals("ON")) {
                    btEnter.setEnabled(true);
                }
                if (currentCmd.equals("BLINK")) {
                    btEnter.setVisibility(View.GONE);
                }
                if (currentCmd.equals("CHIU")) {
                    btEnter.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
