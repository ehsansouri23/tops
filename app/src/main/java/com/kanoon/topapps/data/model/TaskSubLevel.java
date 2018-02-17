package com.kanoon.topapps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ehsan on 2/13/2018.
 */

public class TaskSubLevel {
    @SerializedName("SubLevelId")
    @Expose
    private Integer subLevelId;
    @SerializedName("SubLevelName")
    @Expose
    private String subLevelName;
    @SerializedName("MainId")
    @Expose
    private Integer mainId;

    public Integer getSubLevelId() {
        return subLevelId;
    }

    public void setSubLevelId(Integer subLevelId) {
        this.subLevelId = subLevelId;
    }

    public String getSubLevelName() {
        return subLevelName;
    }

    public void setSubLevelName(String subLevelName) {
        this.subLevelName = subLevelName;
    }

    public Integer getMainId() {
        return mainId;
    }

    public void setMainId(Integer mainId) {
        this.mainId = mainId;
    }
}
