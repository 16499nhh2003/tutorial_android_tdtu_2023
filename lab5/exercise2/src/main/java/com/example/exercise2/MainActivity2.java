package com.example.exercise2;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    String[] places = {"C101", "C102", "C103", "C104"};

    TextView title, place, date, time;
    private int lastSelectedYear;
    private int lastSelectedMonth;
    private int lastSelectedDayOfMonth;

    private int lastSelectedHour = -1;
    private int lastSelectedMinute = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add);

        if (getSupportActionBar() != null) {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ;

        title = findViewById(R.id.title);
        place = findViewById(R.id.place);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);

        place.setOnClickListener(new View.OnClickListener() {
            String text;

            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity2.this)
                        .setTitle("Pick a place")
                        .setSingleChoiceItems(MainActivity2.this.places, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                text = MainActivity2.this.places[i];
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MainActivity2.this.place.setText(text);
                            }
                        })
                        .create();
                alertDialog.show();
            }
        });

        final Calendar c = Calendar.getInstance();
        this.lastSelectedYear = c.get(Calendar.YEAR);
        this.lastSelectedMonth = c.get(Calendar.MONTH);
        this.lastSelectedDayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        lastSelectedYear = year;
                        lastSelectedMonth = monthOfYear;
                        lastSelectedDayOfMonth = dayOfMonth;
                    }

                    ;
                };
                DatePickerDialog datePickerDialog = null;
                datePickerDialog = new DatePickerDialog(MainActivity2.this, dateSetListener, lastSelectedYear, lastSelectedMonth, lastSelectedDayOfMonth);
                datePickerDialog.show();
            }
        });


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                lastSelectedHour = c.get(Calendar.HOUR_OF_DAY);
                lastSelectedMinute = c.get(Calendar.MINUTE);

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay + ":" + minute);
                        lastSelectedHour = hourOfDay;
                        lastSelectedMinute = minute;
                    }

                    ;
                };
                TimePickerDialog timePickerDialog = null;
                timePickerDialog = new TimePickerDialog(MainActivity2.this, timeSetListener, lastSelectedHour, lastSelectedMinute, true);
                timePickerDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btnSave) {
            Intent intent = new Intent();
            intent.putExtra("title", this.title.getText().toString());
            intent.putExtra("place", this.place.getText().toString());
            intent.putExtra("date", this.date.getText().toString());
            intent.putExtra("time", this.time.getText().toString());

            this.setResult(1, intent);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
