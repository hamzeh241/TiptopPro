package com.tiptap.tda_user.tiptap.webService;

public class AppInfo {

    public AppInfo(double version)
    {
        Version = version;
    }

    public double Version;
    public int Id;

    public double getVersion() {
        return Version;
    }

    public void setVersion(double version) {
        Version = version;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
