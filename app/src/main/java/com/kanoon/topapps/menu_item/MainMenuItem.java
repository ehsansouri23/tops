package com.kanoon.topapps.menu_item;

/**
 * Created by ehsan on 2/16/2018.
 */

public class MainMenuItem {
    private int type;
    private int state;
    private String title;
    private String chosen;

    public MainMenuItem(int type, int state) {
        this.type = type;
        this.state = state;
        chosen = "انتخاب کنید...";
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChosen() {
        return chosen;
    }

    public void setChosen(String chosen) {
        this.chosen = chosen;
    }
}
