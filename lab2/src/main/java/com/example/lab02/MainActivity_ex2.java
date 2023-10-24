package com.example.lab02;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity_ex2 extends AppCompatActivity {
    Button btn;
    TextView tvFollowers, tvFollowing;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        init();
        tvFollowers.setText(String.valueOf(generateRandomNumber()));
        tvFollowing.setText(String.valueOf(generateRandomNumber()));
        handle();
    }

    void init() {
        btn = findViewById(R.id.btn);
        tvFollowers = findViewById(R.id.tvFollowers);
        tvFollowing = findViewById(R.id.tvFollowing);
    }

    void handle() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contentButton = btn.getText().toString();

                String numberFollowing = tvFollowing.getText().toString().trim();
                Long valueFollowing = Long.parseLong(numberFollowing);
                String numberFollowers = tvFollowers.getText().toString().trim();
                Long valueFollowers = Long.parseLong(numberFollowers);

                if (contentButton.equalsIgnoreCase("follow")) {
                    valueFollowers += 1;
                    tvFollowers.setText(String.valueOf(valueFollowers));
                    btn.setText("Unfollow");
                } else {
                    valueFollowers -= 1;
                    tvFollowers.setText(String.valueOf(valueFollowers));
                    btn.setText("Follow");

                }
            }
        });
    }
    private long generateRandomNumber() {
        Random random = new Random();
        int min = 100; // Minimum value
        int max = 10000; // Maximum value
        // Generate a random integer between min and max (inclusive)
        return random.nextInt(max - min + 1) + min;
    }
}
