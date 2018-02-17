package com.kanoon.topapps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ehsan on 2/16/2018.
 */

public class TestDate {
    @SerializedName("DateValue")
    @Expose
    private Integer dateValue;
    @SerializedName("hejri")
    @Expose
    private String hejri;

    public Integer getDateValue() {
        return dateValue;
    }

    public void setDateValue(Integer dateValue) {
        this.dateValue = dateValue;
    }

    public String getHejri() {
        return hejri;
    }

    public void setHejri(String hejri) {
        this.hejri = hejri;
    }
}
