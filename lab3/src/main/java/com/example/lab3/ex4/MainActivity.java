package com.example.lab3.ex4;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab3.R;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvPhone, tvEmail, tvAddress, tvHomepage , tvChucvu;
    ImageButton btnEdit;
    ImageView imageView;
    public static final int CODE_INT_REQUEST = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_5);
        init();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("tvName", tvName.getText().toString());
                intent.putExtra("tvPhone", tvPhone.getText().toString());
                intent.putExtra("tvEmail", tvEmail.getText().toString());
                intent.putExtra("tvAddress", tvAddress.getText().toString());
                intent.putExtra("tvHomepage", tvHomepage.getText().toString());
                intent.putExtra("tvChucvu", tvChucvu.getText().toString());

                startActivityForResult(intent, CODE_INT_REQUEST);
            }
        });
    }
    void init() {
        tvName = findViewById(R.id.tvChucVu);
        tvPhone = findViewById(R.id.tvPhone);
        tvEmail = findViewById(R.id.tvEmail);
        tvAddress = findViewById(R.id.tvAddress);
        tvHomepage = findViewById(R.id.tvHomepage);
        btnEdit = findViewById(R.id.btnEdit);
        tvChucvu = findViewById(R.id.tvChucvu);
        imageView = findViewById(R.id.imageView4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODE_INT_REQUEST  &&  resultCode == Activity.RESULT_OK){
            String name = data.getStringExtra("tvName");
            String phone = data.getStringExtra("tvPhone");
            String email = data.getStringExtra("tvEmail");
            String address = data.getStringExtra("tvAddress");
            String homepage = data.getStringExtra("tvHomepage");
            String chucvu = data.getStringExtra("tvChucvu");
            tvName.setText(name);
            tvPhone.setText(phone);
            tvEmail.setText(email);
            tvAddress.setText(address);
            tvHomepage.setText(homepage);
            tvChucvu.setText(chucvu);

            byte[] byteArray = data.getByteArrayExtra("img");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imageView.setImageBitmap(bmp);
        }
    }
}
