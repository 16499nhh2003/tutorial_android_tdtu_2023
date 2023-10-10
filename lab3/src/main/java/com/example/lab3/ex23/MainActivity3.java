package com.example.lab3.ex23;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    EditText editText;
    Button button;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        editText = findViewById(R.id.et);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                Intent chooser = Intent.createChooser(intent , "App with");
                if (chooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
                }
            }
        });


    }
}
