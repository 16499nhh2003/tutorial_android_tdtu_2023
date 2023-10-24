package com.example.lab5;

import android.widget.CheckBox;

public class Item {
    private String name;
    private boolean isChecked;

    public Item(String name , boolean b) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
