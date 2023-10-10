package com.example.lab3.ex1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab3.R;
import com.example.lab3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    Button btnA;
    EditText editText ;
    TextView title ;
    //    ActivityMainBinding binding;
    final static String Key_Name = "name";
    final int REQUEST_RECEIVE_TEXT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
        setContentView(R.layout.activity_main);

        btnA = findViewById(R.id.btnA);
        editText = findViewById(R.id.edA);
        title = findViewById(R.id.textView);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(Key_Name, editText.getText().toString());
                startActivityForResult(intent, REQUEST_RECEIVE_TEXT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_RECEIVE_TEXT: {
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {
                        String email = data.getStringExtra(MainActivity2.KEY_EMAIL);
                        editText.setText(email);
                        editText.setEnabled(false);
                        title.setText("Hẹn gặp lại");
                        btnA.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }
    }
}