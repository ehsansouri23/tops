package com.kanoon.topapps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ehsan on 2/15/2018.
 */

public class Task {
    @SerializedName("Id")
    @Expose
    private int id;
    @SerializedName("CreatorUserId")
    @Expose
    private int creatorUserId;
    @SerializedName("CreateDateTime")
    @Expose
    private String createDateTime;
    @SerializedName("TaskMainId")
    @Expose
    private int taskMainId;
    @SerializedName("TaskSubLevelId")
    @Expose
    private int taskSubLevelId;
    @SerializedName("TaskType")
    @Expose
    private int taskType;
    @SerializedName("Location")
    @Expose
    private int location;
    @SerializedName("ChannelId")
    @Expose
    private int channelId;
    @SerializedName("CourseId")
    @Expose
    private int courseId;
    @SerializedName("GroupMainCode")
    @Expose
    private int groupMainCode;
    @SerializedName("GroupCode")
    @Expose
    private int groupCode;
    @SerializedName("TestDate")
    @Expose
    private int testDate;
    @SerializedName("TestType")
    @Expose
    private int testType;
    @SerializedName("PageCount")
    @Expose
    private int pageCount;
    @SerializedName("Count")
    @Expose
    private int count;
    @SerializedName("QuestionCount")
    @Expose
    private int questionCount;
    @SerializedName("CrsSubject")
    @Expose
    private Object crsSubject;
    @SerializedName("Time")
    @Expose
    private int time;
    @SerializedName("GenerateDate")
    @Expose
    private Object generateDate;
    @SerializedName("Subject")
    @Expose
    private Object subject;
    @SerializedName("SesssionDate")
    @Expose
    private Object sesssionDate;
    @SerializedName("SesssionManager")
    @Expose
    private Object sesssionManager;
    @SerializedName("SesssionLocation")
    @Expose
    private Object sesssionLocation;
    @SerializedName("SendDate")
    @Expose
    private Object sendDate;
    @SerializedName("LearnSource")
    @Expose
    private Object learnSource;
    @SerializedName("BookId")
    @Expose
    private int bookId;
    @SerializedName("Version")
    @Expose
    private int version;
    @SerializedName("Interviewee")
    @Expose
    private Object interviewee;
    @SerializedName("TotalCallCount")
    @Expose
    private int totalCallCount;
    @SerializedName("SuccessCallCount")
    @Expose
    private int successCallCount;
    @SerializedName("UnsuccessfulCallCount")
    @Expose
    private int unsuccessfulCallCount;
    @SerializedName("Category")
    @Expose
    private int category;
    @SerializedName("Owner")
    @Expose
    private Object owner;
    @SerializedName("Description")
    @Expose
    private Object description;
    @SerializedName("TaskValue")
    @Expose
    private int taskValue;
    @SerializedName("StartDate")
    @Expose
    private Object startDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(int creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public int getTaskMainId() {
        return taskMainId;
    }

    public void setTaskMainId(int taskMainId) {
        this.taskMainId = taskMainId;
    }

    public int getTaskSubLevelId() {
        return taskSubLevelId;
    }

    public void setTaskSubLevelId(int taskSubLevelId) {
        this.taskSubLevelId = taskSubLevelId;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getGroupMainCode() {
        return groupMainCode;
    }

    public void setGroupMainCode(int groupMainCode) {
        this.groupMainCode = groupMainCode;
    }

    public int getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(int groupCode) {
        this.groupCode = groupCode;
    }

    public int getTestDate() {
        return testDate;
    }

    public void setTestDate(int testDate) {
        this.testDate = testDate;
    }

    public int getTestType() {
        return testType;
    }

    public void setTestType(int testType) {
        this.testType = testType;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public Object getCrsSubject() {
        return crsSubject;
    }

    public void setCrsSubject(Object crsSubject) {
        this.crsSubject = crsSubject;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Object getGenerateDate() {
        return generateDate;
    }

    public void setGenerateDate(Object generateDate) {
        this.generateDate = generateDate;
    }

    public Object getSubject() {
        return subject;
    }

    public void setSubject(Object subject) {
        this.subject = subject;
    }

    public Object getSesssionDate() {
        return sesssionDate;
    }

    public void setSesssionDate(Object sesssionDate) {
        this.sesssionDate = sesssionDate;
    }

    public Object getSesssionManager() {
        return sesssionManager;
    }

    public void setSesssionManager(Object sesssionManager) {
        this.sesssionManager = sesssionManager;
    }

    public Object getSesssionLocation() {
        return sesssionLocation;
    }

    public void setSesssionLocation(Object sesssionLocation) {
        this.sesssionLocation = sesssionLocation;
    }

    public Object getSendDate() {
        return sendDate;
    }

    public void setSendDate(Object sendDate) {
        this.sendDate = sendDate;
    }

    public Object getLearnSource() {
        return learnSource;
    }

    public void setLearnSource(Object learnSource) {
        this.learnSource = learnSource;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Object getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(Object interviewee) {
        this.interviewee = interviewee;
    }

    public int getTotalCallCount() {
        return totalCallCount;
    }

    public void setTotalCallCount(int totalCallCount) {
        this.totalCallCount = totalCallCount;
    }

    public int getSuccessCallCount() {
        return successCallCount;
    }

    public void setSuccessCallCount(int successCallCount) {
        this.successCallCount = successCallCount;
    }

    public int getUnsuccessfulCallCount() {
        return unsuccessfulCallCount;
    }

    public void setUnsuccessfulCallCount(int unsuccessfulCallCount) {
        this.unsuccessfulCallCount = unsuccessfulCallCount;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Object getOwner() {
        return owner;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public int getTaskValue() {
        return taskValue;
    }

    public void setTaskValue(int taskValue) {
        this.taskValue = taskValue;
    }

    public Object getStartDate() {
        return startDate;
    }

    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", creatorUserId=" + creatorUserId +
                ", createDateTime='" + createDateTime + '\'' +
                ", taskMainId=" + taskMainId +
                ", taskSubLevelId=" + taskSubLevelId +
                ", taskType=" + taskType +
                ", location=" + location +
                ", channelId=" + channelId +
                ", courseId=" + courseId +
                ", groupMainCode=" + groupMainCode +
                ", groupCode=" + groupCode +
                ", testDate=" + testDate +
                ", testType=" + testType +
                ", pageCount=" + pageCount +
                ", count=" + count +
                ", questionCount=" + questionCount +
                ", crsSubject=" + crsSubject +
                ", time=" + time +
                ", generateDate=" + generateDate +
                ", subject=" + subject +
                ", sesssionDate=" + sesssionDate +
                ", sesssionManager=" + sesssionManager +
                ", sesssionLocation=" + sesssionLocation +
                ", sendDate=" + sendDate +
                ", learnSource=" + learnSource +
                ", bookId=" + bookId +
                ", version=" + version +
                ", interviewee=" + interviewee +
                ", totalCallCount=" + totalCallCount +
                ", successCallCount=" + successCallCount +
                ", unsuccessfulCallCount=" + unsuccessfulCallCount +
                ", category=" + category +
                ", owner=" + owner +
                ", description=" + description +
                ", taskValue=" + taskValue +
                ", startDate=" + startDate +
                '}';
    }
}
