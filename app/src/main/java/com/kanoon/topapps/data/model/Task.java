package com.kanoon.topapps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ehsan on 2/15/2018.
 */

public class Task {
    @SerializedName("Id")
    @Expose
    private int id = 0;
    @SerializedName("CreatorUserId")
    @Expose
    private int creatorUserId = 0;
    @SerializedName("CreateDateTime")
    @Expose
    private String createDateTime = "2018-02-28 20:02";
    @SerializedName("TaskMainId")
    @Expose
    private int taskMainId = 0;
    @SerializedName("TaskSubLevelId")
    @Expose
    private int taskSubLevelId = 0;
    @SerializedName("TaskType")
    @Expose
    private int taskType = 0;
    @SerializedName("Location")
    @Expose
    private int location = 0;
    @SerializedName("ChannelId")
    @Expose
    private int channelId = 0;
    @SerializedName("CourseId")
    @Expose
    private int courseId = 0;
    @SerializedName("GroupMainCode")
    @Expose
    private int groupMainCode = 0;
    @SerializedName("GroupCode")
    @Expose
    private int groupCode = 0;
    @SerializedName("TestDate")
    @Expose
    private int testDate = 0;
    @SerializedName("TestType")
    @Expose
    private int testType = 0;
    @SerializedName("PageCount")
    @Expose
    private int pageCount = 0;
    @SerializedName("Count")
    @Expose
    private int count = 0;
    @SerializedName("QuestionCount")
    @Expose
    private int questionCount = 0;
    @SerializedName("CrsSubject")
    @Expose
    private String crsSubject = "";
    @SerializedName("Time")
    @Expose
    private int time = 0;
    @SerializedName("GenerateDate")
    @Expose
    private String generateDate = "";
    @SerializedName("Subject")
    @Expose
    private String subject = "";
    @SerializedName("SesssionDate")
    @Expose
    private String sesssionDate = "";
    @SerializedName("SesssionManager")
    @Expose
    private String sesssionManager = "";
    @SerializedName("SesssionLocation")
    @Expose
    private String sesssionLocation = "";
    @SerializedName("SendDate")
    @Expose
    private String sendDate = "";
    @SerializedName("LearnSource")
    @Expose
    private String learnSource = "";
    @SerializedName("BookId")
    @Expose
    private int bookId = 0;
    @SerializedName("Version")
    @Expose
    private int version = 0;
    @SerializedName("Interviewee")
    @Expose
    private String interviewee = "";
    @SerializedName("TotalCallCount")
    @Expose
    private int totalCallCount = 0;
    @SerializedName("SuccessCallCount")
    @Expose
    private int successCallCount = 0;
    @SerializedName("UnsuccessfulCallCount")
    @Expose
    private int unsuccessfulCallCount = 0;
    @SerializedName("Category")
    @Expose
    private int category = 0;
    @SerializedName("Owner")
    @Expose
    private String owner = "";
    @SerializedName("Description")
    @Expose
    private String description = "";
    @SerializedName("TaskValue")
    @Expose
    private int taskValue = 0;
    @SerializedName("StartDate")
    @Expose
    private String startDate = "";
    @SerializedName("ManagerUserId")
    @Expose
    private Integer ManagerUserId = 0;

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

    public String getCrsSubject() {
        return crsSubject;
    }

    public void setCrsSubject(String crsSubject) {
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

    public void setGenerateDate(String generateDate) {
        this.generateDate = generateDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Object getSesssionDate() {
        return sesssionDate;
    }

    public void setSesssionDate(String sesssionDate) {
        this.sesssionDate = sesssionDate;
    }

    public Object getSesssionManager() {
        return sesssionManager;
    }

    public void setSesssionManager(String sesssionManager) {
        this.sesssionManager = sesssionManager;
    }

    public Object getSesssionLocation() {
        return sesssionLocation;
    }

    public void setSesssionLocation(String sesssionLocation) {
        this.sesssionLocation = sesssionLocation;
    }

    public Object getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getLearnSource() {
        return learnSource;
    }

    public void setLearnSource(String learnSource) {
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

    public String getInterviewee() {
        return interviewee;
    }

    public void setInterviewee(String interviewee) {
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getManagerUserId() {
        return ManagerUserId;
    }

    public void setManagerUserId(Integer managerUserId) {
        ManagerUserId = managerUserId;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                " \"creatorUserId\":" + creatorUserId + "," +
                " \"createDateTime\":" + createDateTime + '\'' +
                " \"taskMainId\":" + taskMainId + "," +
                " \"taskSubLevelId\":" + taskSubLevelId + "," +
                " \"taskType\":" + taskType + "," +
                " \"location\":" + location + "," +
                " \"channelId\":" + channelId + "," +
                " \"courseId\":" + courseId + "," +
                " \"groupMainCode\":" + groupMainCode + "," +
                " \"groupCode\":" + groupCode + "," +
                " \"testDate\":" + testDate + "," +
                " \"testType\":" + testType + "," +
                " \"pageCount\":" + pageCount + "," +
                " \"count\":" + count + "," +
                " \"questionCount\":" + questionCount + "," +
                " \"crsSubject\":" + crsSubject + "," +
                " \"time\":" + time + "," +
                " \"generateDate\":" + generateDate + "," +
                " \"subject\":" + subject + "," +
                " \"sesssionDate\":" + sesssionDate + "," +
                " \"sesssionManager\":" + sesssionManager + "," +
                " \"sesssionLocation\":" + sesssionLocation + "," +
                " \"sendDate\":" + sendDate + "," +
                " \"learnSource\":" + learnSource + "," +
                " \"bookId\":" + bookId + "," +
                " \"version\":" + version + "," +
                " \"interviewee\":" + interviewee + "," +
                " \"totalCallCount\":" + totalCallCount + "," +
                " \"successCallCount\":" + successCallCount + "," +
                " \"unsuccessfulCallCount\":" + unsuccessfulCallCount + "," +
                " \"category\":" + category + "," +
                " \"owner\":" + owner + "," +
                " \"description\":" + description + "," +
                " \"taskValue\":" + taskValue + "," +
                " \"startDate\":" + startDate + "," +
                '}';
    }
}
