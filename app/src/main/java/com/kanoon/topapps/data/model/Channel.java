package com.kanoon.topapps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ehsan on 2/16/2018.
 */

public class Channel {
    @SerializedName("ChanneId")
    @Expose
    private Integer channeId;
    @SerializedName("ChanneName")
    @Expose
    private String channeName;

    public Integer getChanneId() {
        return channeId;
    }

    public void setChanneId(Integer channeId) {
        this.channeId = channeId;
    }

    public String getChanneName() {
        return channeName;
    }

    public void setChanneName(String channeName) {
        this.channeName = channeName;
    }
}
