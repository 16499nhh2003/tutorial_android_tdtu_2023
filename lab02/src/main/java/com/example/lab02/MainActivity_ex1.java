package com.example.lab02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity_ex1 extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnSignIn, btnReset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
        init();
        handle();
    }

    void init() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnReset = findViewById(R.id.btnReset);
    }

    void handle() {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pwd = etPassword.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                if (etPassword.getText().toString().length() == 0 || etUsername.getText().toString().isEmpty()) {
                    Toast.makeText(view.getContext(), "Vui lòng nhập username hoặc password", Toast.LENGTH_LONG).show();
                } else if (username.equals("admin") && pwd.equals("admin1234")) {
                    Toast.makeText(view.getContext(), "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                } else if (pwd.length() < 6 || !findLeastUpperAndLower(pwd)) {
                    Toast.makeText(view.getContext(), "Mật khẩu không đúng yêu cầu", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString().trim();
                if (username.isEmpty()) {
                    Toast.makeText(view.getContext(), "Vui lòng nhập username", Toast.LENGTH_LONG).show();
                } else if (username.equals("admin")) {
                    Toast.makeText(view.getContext(), "Reset mật khẩu thành công", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    boolean findLeastUpperAndLower(String req) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z]).*$");
        Matcher matcher = pattern.matcher(req);
        return matcher.matches();
    }
}
