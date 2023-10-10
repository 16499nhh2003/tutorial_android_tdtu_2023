package com.example.lab3.ex4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Debug;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3.R;

import java.io.ByteArrayOutputStream;

public class MainActivity2 extends AppCompatActivity {
    EditText etChucVu, etName, etPhone, etEmail, etAddress, etHomepage;
    ImageButton imageButton4;
    ImageView img;
    Button btnSave;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_6);
        init();
        Intent intent = getIntent();
        etName.setText(intent.getStringExtra("tvName"));
        etChucVu.setText(intent.getStringExtra("tvChucvu"));
        etPhone.setText(intent.getStringExtra("tvPhone"));
        etEmail.setText(intent.getStringExtra("tvEmail"));
        etAddress.setText(intent.getStringExtra("tvAddress"));
        etHomepage.setText(intent.getStringExtra("tvHomepage"));

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent1, 99);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.putExtra("tvName", etName.getText().toString());
                intent1.putExtra("tvPhone", etPhone.getText().toString());
                intent1.putExtra("tvEmail", etEmail.getText().toString());
                intent1.putExtra("tvAddress", etAddress.getText().toString());
                intent1.putExtra("tvHomepage", etHomepage.getText().toString());
                intent1.putExtra("tvChucvu", etChucVu.getText().toString());

                //Convert to byte array
                Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] imageInByte = baos.toByteArray();
                intent1.putExtra("img", imageInByte);

                setResult(Activity.RESULT_OK, intent1);
                finish();
            }
        });

    }

    void init() {
        etChucVu = findViewById(R.id.etChucVu);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etAddress = findViewById(R.id.etAddress);
        etHomepage = findViewById(R.id.etHomepage);
        imageButton4 = findViewById(R.id.imageButton4);
        img = findViewById(R.id.img);
        btnSave = findViewById(R.id.btnSave);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(photo);
        }
    }
}
