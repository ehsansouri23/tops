package com.kanoon.topapps.data.model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kanoon.topapps.consts.State;

import java.util.HashMap;

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
    @SerializedName("IsManagerUserId")
    @Expose
    private Boolean IsManagerUserId;

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

    public Boolean getManagerUserId() {
        return IsManagerUserId;
    }

    public void setManagerUserId(Boolean managerUserId) {
        IsManagerUserId = managerUserId;
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

    public int getNextState(int curState) {
        if (curState == State.STATE_GROUP_MAIN_CODE)
            return State.STATE_GROUP_CODE;

        curState++;
        for (int i = curState; i <= State.STATE_FINISH; i++) {
            switch (i) {
                case State.STATE_TASK_SUBLEVEL:
                    if (getTaskSubLevel())
                        return State.STATE_TASK_SUBLEVEL;
                    break;
                case State.STATE_TASK_TYPE:
                    if (getTaskTypes())
                        return State.STATE_TASK_TYPE;
                    break;
                case State.STATE_MANAGER_USER_ID:
                    if (getManagerUserId())
                        return State.STATE_MANAGER_USER_ID;
                    break;
                case State.STATE_GROUP_MAIN_CODE:
                    if (getIsGroup())
                        return State.STATE_GROUP_MAIN_CODE;
                    break;
                case State.STATE_GROUP_CODE:
                    if (getIsGroup())
                        return State.STATE_GROUP_CODE;
                    break;
                case State.STATE_TEST_DATE:
                    if (getIsTestDate())
                        return State.STATE_TEST_DATE;
                    break;
                case State.STATE_COURSE_ID:
                    if (getIsCourse())
                        return State.STATE_COURSE_ID;
                    break;
                case State.STATE_BOOKS:
                    if (getIsBookName())
                        return State.STATE_BOOKS;
                    break;
                case State.STATE_VERSION:
                    if (getIsVersion())
                        return State.STATE_VERSION;
                    break;
                case State.STATE_LOCATION:
                    if (getIsLocation())
                        return State.STATE_LOCATION;
                    break;
                case State.STATE_CHANNEL_ID:
                    if (getIsLocation())
                        return State.STATE_CHANNEL_ID;
                    break;
                case State.STATE_TEST_TYPE:
                    if (getIsTestType())
                        return State.STATE_TEST_TYPE;
                    break;
                case State.STATE_CATEGORY:
                    if (getIsCatagory())
                        return State.STATE_CATEGORY;
                    break;
                case State.STATE_CRS_SUBJECT:
                    if (getIsCrsSubject())
                        return State.STATE_CRS_SUBJECT;
                    break;
                case State.STATE_SUBJECT:
                    if (getIsSubject())
                        return State.STATE_SUBJECT;
                    break;
                case State.STATE_SESSION_DATE:
                    if (getIsSesssionDate())
                        return State.STATE_SESSION_DATE;
                    break;
                case State.STATE_SESSION_LOCATION:
                    if (getIsSesssionLocation())
                        return State.STATE_SESSION_LOCATION;
                    break;
                case State.STATE_SESSION_MANAGER:
                    if (getIsSesssionManager())
                        return State.STATE_SESSION_MANAGER;
                    break;
                case State.STATE_TOTAL_CALL_COUNT:
                    if (getIsTotalCallCount())
                        return State.STATE_TOTAL_CALL_COUNT;
                    break;
                case State.STATE_SUCCESSFUL_CALL_COUNT:
                    if (getIsSuccessCallCount())
                        return State.STATE_SUCCESSFUL_CALL_COUNT;
                    break;
                case State.STATE_UNSUCCESSFUL_CALL_COUNT:
                    if (getIsUnsuccessfulCallCount())
                        return State.STATE_UNSUCCESSFUL_CALL_COUNT;
                    break;
                case State.STATE_OWNER:
                    if (getIsOwner())
                        return State.STATE_OWNER;
                    break;
                case State.STATE_INTERVIEWEE:
                    if (getIsInterviewee())
                        return State.STATE_INTERVIEWEE;
                    break;
                case State.STATE_LEARN_SOURCE:
                    if (getIsLearnSource())
                        return State.STATE_LEARN_SOURCE;
                    break;
                case State.STATE_DESCRIPTION:
                    if (getIsDescription())
                        return State.STATE_DESCRIPTION;
                    break;
                case State.STATE_COUNT:
                    if (getIsCourse())
                        return State.STATE_COUNT;
                    break;
                case State.STATE_PAGE_COUNT:
                    if (getIsPageCount())
                        return State.STATE_PAGE_COUNT;
                    break;
                case State.STATE_QUESTION_COUNT:
                    if (getIsQuestionCount())
                        return State.STATE_QUESTION_COUNT;
                    break;
                case State.STATE_TIME:
                    if (getIstime())
                        return State.STATE_TIME;
                    break;
                case State.STATE_GENERATE_DATE:
                    if (getIsGenerateDate())
                        return State.STATE_GENERATE_DATE;
                    break;
                case State.STATE_SEND_DATE:
                    if (getIsSendDate())
                        return State.STATE_SEND_DATE;
                    break;
                default:
                    return State.STATE_FINISH;
            }
        }
        return -1;
    }
}
