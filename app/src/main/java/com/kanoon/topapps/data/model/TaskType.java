package com.kanoon.topapps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ehsan on 2/15/2018.
 */

public class TaskType {

    @SerializedName("IsLocation")
    @Expose
    private Boolean isLocation;
    @SerializedName("IsCourse")
    @Expose
    private Boolean isCourse;
    @SerializedName("IsGroup")
    @Expose
    private Boolean isGroup;
    @SerializedName("IsTestDate")
    @Expose
    private Boolean isTestDate;
    @SerializedName("IsPageCount")
    @Expose
    private Boolean isPageCount;
    @SerializedName("IsCount")
    @Expose
    private Boolean isCount;
    @SerializedName("IsQuestionCount")
    @Expose
    private Boolean isQuestionCount;
    @SerializedName("IsCrsSubject")
    @Expose
    private Boolean isCrsSubject;
    @SerializedName("Istime")
    @Expose
    private Boolean istime;
    @SerializedName("IsGenerateDate")
    @Expose
    private Boolean isGenerateDate;
    @SerializedName("IsSubject")
    @Expose
    private Boolean isSubject;
    @SerializedName("IsSesssionDate")
    @Expose
    private Boolean isSesssionDate;
    @SerializedName("IsSesssionManager")
    @Expose
    private Boolean isSesssionManager;
    @SerializedName("IsSesssionLocation")
    @Expose
    private Boolean isSesssionLocation;
    @SerializedName("IsSendDate")
    @Expose
    private Boolean isSendDate;
    @SerializedName("IsLearnSource")
    @Expose
    private Boolean isLearnSource;
    @SerializedName("IsBookName")
    @Expose
    private Boolean isBookName;
    @SerializedName("IsVersion")
    @Expose
    private Boolean isVersion;
    @SerializedName("IsInterviewee")
    @Expose
    private Boolean isInterviewee;
    @SerializedName("IsTotalCallCount")
    @Expose
    private Boolean isTotalCallCount;
    @SerializedName("IsSuccessCallCount")
    @Expose
    private Boolean isSuccessCallCount;
    @SerializedName("IsUnsuccessfulCallCount")
    @Expose
    private Boolean isUnsuccessfulCallCount;
    @SerializedName("IsCatagory")
    @Expose
    private Boolean isCatagory;
    @SerializedName("IsOwner")
    @Expose
    private Boolean isOwner;
    @SerializedName("IsDescription")
    @Expose
    private Boolean isDescription;
    @SerializedName("IsTestType")
    @Expose
    private Boolean isTestType;

    private Boolean isTaskMain = true;
    private Boolean isTaskSubLevel = true;
    private Boolean isTaskTypes = true;

    public Boolean getIsLocation() {
        return isLocation;
    }

    public void setIsLocation(Boolean isLocation) {
        this.isLocation = isLocation;
    }

    public Boolean getIsCourse() {
        return isCourse;
    }

    public void setIsCourse(Boolean isCourse) {
        this.isCourse = isCourse;
    }

    public Boolean getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Boolean isGroup) {
        this.isGroup = isGroup;
    }

    public Boolean getIsTestDate() {
        return isTestDate;
    }

    public void setIsTestDate(Boolean isTestDate) {
        this.isTestDate = isTestDate;
    }

    public Boolean getIsPageCount() {
        return isPageCount;
    }

    public void setIsPageCount(Boolean isPageCount) {
        this.isPageCount = isPageCount;
    }

    public Boolean getIsCount() {
        return isCount;
    }

    public void setIsCount(Boolean isCount) {
        this.isCount = isCount;
    }

    public Boolean getIsQuestionCount() {
        return isQuestionCount;
    }

    public void setIsQuestionCount(Boolean isQuestionCount) {
        this.isQuestionCount = isQuestionCount;
    }

    public Boolean getIsCrsSubject() {
        return isCrsSubject;
    }

    public void setIsCrsSubject(Boolean isCrsSubject) {
        this.isCrsSubject = isCrsSubject;
    }

    public Boolean getIstime() {
        return istime;
    }

    public void setIstime(Boolean istime) {
        this.istime = istime;
    }

    public Boolean getIsGenerateDate() {
        return isGenerateDate;
    }

    public void setIsGenerateDate(Boolean isGenerateDate) {
        this.isGenerateDate = isGenerateDate;
    }

    public Boolean getIsSubject() {
        return isSubject;
    }

    public void setIsSubject(Boolean isSubject) {
        this.isSubject = isSubject;
    }

    public Boolean getIsSesssionDate() {
        return isSesssionDate;
    }

    public void setIsSesssionDate(Boolean isSesssionDate) {
        this.isSesssionDate = isSesssionDate;
    }

    public Boolean getIsSesssionManager() {
        return isSesssionManager;
    }

    public void setIsSesssionManager(Boolean isSesssionManager) {
        this.isSesssionManager = isSesssionManager;
    }

    public Boolean getIsSesssionLocation() {
        return isSesssionLocation;
    }

    public void setIsSesssionLocation(Boolean isSesssionLocation) {
        this.isSesssionLocation = isSesssionLocation;
    }

    public Boolean getIsSendDate() {
        return isSendDate;
    }

    public void setIsSendDate(Boolean isSendDate) {
        this.isSendDate = isSendDate;
    }

    public Boolean getIsLearnSource() {
        return isLearnSource;
    }

    public void setIsLearnSource(Boolean isLearnSource) {
        this.isLearnSource = isLearnSource;
    }

    public Boolean getIsBookName() {
        return isBookName;
    }

    public void setIsBookName(Boolean isBookName) {
        this.isBookName = isBookName;
    }

    public Boolean getIsVersion() {
        return isVersion;
    }

    public void setIsVersion(Boolean isVersion) {
        this.isVersion = isVersion;
    }

    public Boolean getIsInterviewee() {
        return isInterviewee;
    }

    public void setIsInterviewee(Boolean isInterviewee) {
        this.isInterviewee = isInterviewee;
    }

    public Boolean getIsTotalCallCount() {
        return isTotalCallCount;
    }

    public void setIsTotalCallCount(Boolean isTotalCallCount) {
        this.isTotalCallCount = isTotalCallCount;
    }

    public Boolean getIsSuccessCallCount() {
        return isSuccessCallCount;
    }

    public void setIsSuccessCallCount(Boolean isSuccessCallCount) {
        this.isSuccessCallCount = isSuccessCallCount;
    }

    public Boolean getIsUnsuccessfulCallCount() {
        return isUnsuccessfulCallCount;
    }

    public void setIsUnsuccessfulCallCount(Boolean isUnsuccessfulCallCount) {
        this.isUnsuccessfulCallCount = isUnsuccessfulCallCount;
    }

    public Boolean getIsCatagory() {
        return isCatagory;
    }

    public void setIsCatagory(Boolean isCatagory) {
        this.isCatagory = isCatagory;
    }

    public Boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    public Boolean getIsDescription() {
        return isDescription;
    }

    public void setIsDescription(Boolean isDescription) {
        this.isDescription = isDescription;
    }

    public Boolean getIsTestType() {
        return isTestType;
    }

    public void setIsTestType(Boolean isTestType) {
        this.isTestType = isTestType;
    }

    public Boolean getTaskMain() {
        return isTaskMain;
    }

    public void setTaskMain(Boolean taskMain) {
        isTaskMain = taskMain;
    }

    public Boolean getTaskSubLevel() {
        return isTaskSubLevel;
    }

    public void setTaskSubLevel(Boolean taskSubLevel) {
        isTaskSubLevel = taskSubLevel;
    }

    public Boolean getTaskTypes() {
        return isTaskTypes;
    }

    public void setTaskTypes(Boolean taskTypes) {
        isTaskTypes = taskTypes;
    }

    @Override
    public String toString() {
        return "TaskType{" +
                "isLocation=" + isLocation +
                ", isCourse=" + isCourse +
                ", isGroup=" + isGroup +
                ", isTestDate=" + isTestDate +
                ", isPageCount=" + isPageCount +
                ", isCount=" + isCount +
                ", isQuestionCount=" + isQuestionCount +
                ", isCrsSubject=" + isCrsSubject +
                ", istime=" + istime +
                ", isGenerateDate=" + isGenerateDate +
                ", isSubject=" + isSubject +
                ", isSesssionDate=" + isSesssionDate +
                ", isSesssionManager=" + isSesssionManager +
                ", isSesssionLocation=" + isSesssionLocation +
                ", isSendDate=" + isSendDate +
                ", isLearnSource=" + isLearnSource +
                ", isBookName=" + isBookName +
                ", isVersion=" + isVersion +
                ", isInterviewee=" + isInterviewee +
                ", isTotalCallCount=" + isTotalCallCount +
                ", isSuccessCallCount=" + isSuccessCallCount +
                ", isUnsuccessfulCallCount=" + isUnsuccessfulCallCount +
                ", isCatagory=" + isCatagory +
                ", isOwner=" + isOwner +
                ", isDescription=" + isDescription +
                ", isTestType=" + isTestType +
                '}';
    }
}
