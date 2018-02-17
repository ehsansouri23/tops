package com.kanoon.topapps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ehsan on 2/16/2018.
 */

public class Course {
    @SerializedName("CourseId")
    @Expose
    private Integer courseId;
    @SerializedName("CourseName")
    @Expose
    private String courseName;
    @SerializedName("GroupCode")
    @Expose
    private Integer groupCode;
    @SerializedName("IsSpecial")
    @Expose
    private Integer isSpecial;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(Integer groupCode) {
        this.groupCode = groupCode;
    }

    public Integer getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Integer isSpecial) {
        this.isSpecial = isSpecial;
    }
}
