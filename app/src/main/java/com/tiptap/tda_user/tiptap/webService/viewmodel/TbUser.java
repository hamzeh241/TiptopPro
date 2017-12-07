package com.tiptap.tda_user.tiptap.webService.viewmodel;

public class TbUser {

    private String ApplicationId;
    private String UserId;
    private String UserName;
    private String LoweredUserName;
    private String MobileAlias;
    private boolean IsAnonymous;
    private String LastActivityDate;
    private int Id_Lesson;

    public TbUser() {}

    public String getApplicationId() {
        return ApplicationId;
    }

    public void setApplicationId(String applicationId) {
        ApplicationId = applicationId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getLoweredUserName() {
        return LoweredUserName;
    }

    public void setLoweredUserName(String loweredUserName) {
        LoweredUserName = loweredUserName;
    }

    public String getMobileAlias() {
        return MobileAlias;
    }

    public void setMobileAlias(String mobileAlias) {
        MobileAlias = mobileAlias;
    }

    public boolean isAnonymous() {
        return IsAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        IsAnonymous = anonymous;
    }

    public String getLastActivityDate() {
        return LastActivityDate;
    }

    public void setLastActivityDate(String lastActivityDate) {
        LastActivityDate = lastActivityDate;
    }

    public int getId_Lesson() {
        return Id_Lesson;
    }

    public void setId_Lesson(int id_Lesson) {
        Id_Lesson = id_Lesson;
    }
}