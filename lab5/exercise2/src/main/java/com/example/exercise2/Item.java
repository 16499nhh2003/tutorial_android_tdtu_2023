package com.example.exercise2;

import java.util.Date;

public class Item {
    private String title;
    private String nameRoom;
    private String date;
    private boolean isEnable;

    public Item(String title, String nameRoom, String date, boolean isEnable) {
        this.title = title;
        this.nameRoom = nameRoom;
        this.date = date;
        this.isEnable = isEnable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
