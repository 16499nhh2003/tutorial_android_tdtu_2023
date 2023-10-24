package com.example.ex3;

import android.widget.CheckBox;

public class Item {
    private String title ;
    private boolean check;

    public Item(String title, boolean check) {
        this.title = title;
        this.check = check;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
