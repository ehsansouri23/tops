package com.kanoon.topapps.modal;

/**
 * Created by ehsan on 2/15/2018.
 */

public class ModalMenuItem {
    private String name;
    private int id;

    public ModalMenuItem(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
