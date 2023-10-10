package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class activity_main_bai5 extends AppCompatActivity {
    CheckBox cbAndroid ,cbIOS, cbWin, cbRIM;
    RadioButton rbAndroid ,rbIOS, rbWin, rbRIM;
    Button btSubmit;
    TextView tvResult,tvResultRadio;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);
        initView();
        handle();
    }

    private void initView(){
        cbAndroid = findViewById(R.id.cbAndroid);
        cbIOS = findViewById(R.id.cbIOS);
        cbWin = findViewById(R.id.cbWin);
        cbRIM = findViewById(R.id.cbRIM);

        btSubmit = findViewById(R.id.btSubmit);
        tvResult = findViewById(R.id.tvResult);
        tvResultRadio = findViewById(R.id.tvResultRadio);

        rbAndroid = findViewById(R.id.rbAndroid);
        rbIOS = findViewById(R.id.rbIOS);
        rbWin = findViewById(R.id.rbWin);
        rbRIM = findViewById(R.id.rbRIM);
    }

    private void handle(){
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rs = "The following  were selected by checkbox ... " +
                        "\nAndroid : " + (cbAndroid.isChecked())  +
                        "\nIOS : " + cbIOS.isChecked()  +
                        "\nWindows : " + cbWin.isChecked()  +
                        "\nRIM : " + cbRIM.isChecked() ;

                String rb = "The following  were selected  by radio box ... " +
                        "\nAndroid : " + (rbAndroid.isChecked())  +
                        "\nIOS : " + rbIOS.isChecked()  +
                        "\nWindows : " + rbWin.isChecked()  +
                        "\nRIM : " + rbRIM.isChecked() ;

                tvResultRadio.setText(rb);
                tvResult.setText(rs);
            }
        });

    }

}
