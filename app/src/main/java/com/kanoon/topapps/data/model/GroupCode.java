package com.kanoon.topapps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ehsan on 2/16/2018.
 */

public class GroupCode {
    @SerializedName("GroupCode1")
    @Expose
    private Integer groupCode1;
    @SerializedName("MainCode")
    @Expose
    private Integer mainCode;
    @SerializedName("GroupName")
    @Expose
    private String groupName;

    public Integer getGroupCode1() {
        return groupCode1;
    }

    public void setGroupCode1(Integer groupCode1) {
        this.groupCode1 = groupCode1;
    }

    public Integer getMainCode() {
        return mainCode;
    }

    public void setMainCode(Integer mainCode) {
        this.mainCode = mainCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
