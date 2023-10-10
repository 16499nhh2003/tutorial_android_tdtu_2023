package com.example.lab1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class activity_main_bai3 extends AppCompatActivity {
    Button bt_plus,bt_minus;
    TextView tv_percent, tv_tip, tv_total;
    EditText et_bill;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        mapping();
        handlerEvent();
    }
    private void mapping(){
        bt_minus = findViewById(R.id.bt_minus);
        bt_plus = findViewById(R.id.bt_plus);
        tv_percent = findViewById(R.id.tv_percent);
        tv_tip = findViewById(R.id.tv_tip);
        et_bill = findViewById(R.id.et_bill);
        tv_total = findViewById(R.id.tv_total);
    }

    private void handlerEvent(){
        et_bill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String currentValue = et_bill.getText().toString().trim();
                double billAmount = Double.parseDouble(currentValue);

                String valuePercent = tv_percent.getText().toString().trim().replace("%", "");
                double tipPercentage = Double.parseDouble(valuePercent) / 100;

                double tip = billAmount * tipPercentage;
                double total = billAmount - tip;

                // Get the default locale or a specific locale of your choice
                Locale locale = Locale.getDefault();
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

                String formattedTip = currencyFormatter.format(tip);
                String formattedTotal = currencyFormatter.format(total);

                tv_tip.setText(formattedTip);
                tv_total.setText(formattedTotal);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        bt_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String percent = tv_percent.getText().toString().trim();
                percent = percent.replace("%","");
                double percentValue = Double.parseDouble(percent);

                double newPercent = percentValue + 1;
                tv_percent.setText(String.valueOf(newPercent) + "%");
            }
        });

        bt_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String percent = tv_percent.getText().toString().trim();
                percent = percent.replace("%","");
                double percentValue = Double.parseDouble(percent);

                double newPercent = percentValue - 1;
                tv_percent.setText(String.valueOf(newPercent) + "%");
            }
        });

        tv_percent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String percent = tv_percent.getText().toString().trim();
                percent = percent.replace("%","");
                double percentValue = Double.parseDouble(percent);

                if (percentValue == 5){
                     bt_minus.setEnabled(false);
                }
                else{
                    bt_minus.setEnabled(true);
                }

                String currentValue = et_bill.getText().toString().trim();
                double billAmount = Double.parseDouble(currentValue);

                String valuePercent = tv_percent.getText().toString().trim().replace("%", "");
                double tipPercentage = Double.parseDouble(valuePercent) / 100;

                double tip = billAmount * tipPercentage;
                double total = billAmount - tip;

                // Get the default locale or a specific locale of your choice
                Locale locale = Locale.getDefault();
                NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

                String formattedTip = currencyFormatter.format(tip);
                String formattedTotal = currencyFormatter.format(total);

                tv_tip.setText(formattedTip);
                tv_total.setText(formattedTotal);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

}
