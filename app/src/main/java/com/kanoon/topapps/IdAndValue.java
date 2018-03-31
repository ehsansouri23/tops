package com.kanoon.topapps;

/**
 * Created by ehsan on 2/27/2018.
 */

public class IdAndValue {
    private int id;
    private String value;

    public IdAndValue(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
