package com.runzhi.workplacedemo.personaltask;

public class PersonalTaskDataModel {

    private String mTitle;
    private String mDescription;
    private TaskStatus mTaskStatus;

    public PersonalTaskDataModel(String mTitle, String mDescription) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
    }

    public PersonalTaskDataModel(String mTitle, String mDescription, TaskStatus mTaskStatus) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mTaskStatus = mTaskStatus;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public TaskStatus getmTaskStatus() {
        return mTaskStatus;
    }

    public void setmTaskStatus(TaskStatus mTaskStatus) {
        this.mTaskStatus = mTaskStatus;
    }
}
