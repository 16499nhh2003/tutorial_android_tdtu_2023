package com.example.lab1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_main_bai4 extends AppCompatActivity {
    TextView etUs, etEuros, etVND;
    Button btClear, btConvert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        initView();
        handleEvent();
    }

    private void initView() {
        etUs = findViewById(R.id.etUs);
        etEuros = findViewById(R.id.etEuros);
        etVND = findViewById(R.id.etVND);
        btClear = findViewById(R.id.btClear);
        btConvert = findViewById(R.id.btConvert);
    }

    private static final double RATING_EURO = 0.94;
    private static final double RATING_VND = 24250.0;

    private void handleEvent() {

        btConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = etUs.getText().toString().trim();
                try {
                    double valueUs = Double.parseDouble(currentValue);
                    double doubleEuros = convertUs(valueUs, RATING_EURO);
                    double doubleVND = convertUs(valueUs, RATING_VND);
                    etEuros.setText(String.valueOf(doubleEuros) + "Euro");
                    etVND.setText(String.valueOf(doubleVND) + "VND");
                } catch (Exception e) {
                    Toast.makeText(view.getContext(), "Enter information suitable", Toast.LENGTH_LONG).show();
                }
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEuros.setText("");
                etVND.setText("");
                etUs.setText("");
            }
        });
    }

    private double convertUs(double dollars, double exchangeRate) {
        if (dollars < 0 || exchangeRate < 0) {
            return -1; // Handle negative values or other invalid inputs
        }
        // Conversion formula
        return dollars * exchangeRate;
    }
}
