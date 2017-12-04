package com.tiptap.tda_user.tiptap.webService.viewmodel;

public class ActivityTypeViewModel {

    private String id_activityType;
    private String title_activityType;
    private String row_version;

    public ActivityTypeViewModel(){}

    public String getId_activityType() {
        return id_activityType;
    }

    public void setId_activityType(String id_activityType) {
        this.id_activityType = id_activityType;
    }

    public String getTitle_activityType() {
        return title_activityType;
    }

    public void setTitle_activityType(String title_activityType) {
        this.title_activityType = title_activityType;
    }

    public String getRow_version() {
        return row_version;
    }

    public void setRow_version(String row_version) {
        this.row_version = row_version;
    }
}
