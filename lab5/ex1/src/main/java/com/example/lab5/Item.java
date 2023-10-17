package com.example.lab5;

import android.widget.CheckBox;

public class Item {
    private String name;
    private CheckBox checkBox;

    public Item(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setItemCheck(boolean check){
        this.checkBox.setChecked(check);
    }
    public boolean getCheckBox() {
        return this.checkBox.isChecked();
    }
    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
