package com.kanoon.topapps.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ehsan on 3/31/2018.
 */

public class TimeSheet {

    @SerializedName("Data")
    @Expose
    private Data data;
    @SerializedName("Message")
    @Expose
    private String message;

    public class Data {
        @SerializedName("TimeSheets")
        @Expose
        private List<TimeSheets> timeSheets;

        public List<TimeSheets> getTimeSheets() {
            return timeSheets;
        }

        public void setTimeSheets(List<TimeSheets> timeSheets) {
            this.timeSheets = timeSheets;
        }
    }

    public class TimeSheets {
        @SerializedName("HejriDate")
        @Expose
        private int hejriDate;
        @SerializedName("StartTime")
        @Expose
        private StartTime startTime;
        @SerializedName("EndTime")
        @Expose
        private EndTime endTime;
        @SerializedName("Duration")
        @Expose
        private Duration duration;

        public int getHejriDate() {
            return hejriDate;
        }

        public void setHejriDate(int hejriDate) {
            this.hejriDate = hejriDate;
        }

        public StartTime getStartTime() {
            return startTime;
        }

        public void setStartTime(StartTime startTime) {
            this.startTime = startTime;
        }

        public EndTime getEndTime() {
            return endTime;
        }

        public void setEndTime(EndTime endTime) {
            this.endTime = endTime;
        }

        public Duration getDuration() {
            return duration;
        }

        public void setDuration(Duration duration) {
            this.duration = duration;
        }
    }

    public class StartTime {
        @SerializedName("Hours")
        @Expose
        private int hour;
        @SerializedName("Minutes")
        @Expose
        private int minute;
        @SerializedName("Seconds")
        @Expose
        private int second;

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }

    public class EndTime {
        @SerializedName("Hours")
        @Expose
        private int hour;
        @SerializedName("Minutes")
        @Expose
        private int minute;
        @SerializedName("Seconds")
        @Expose
        private int second;

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }

    public class Duration {
        @SerializedName("Hours")
        @Expose
        private int hour;
        @SerializedName("Minutes")
        @Expose
        private int minute;
        @SerializedName("Seconds")
        @Expose
        private int second;

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
