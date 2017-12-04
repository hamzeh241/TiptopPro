package com.tiptap.tda_user.tiptap.webService;

public interface IAppInfo {
    //List<AppInfo> getInfoApp();
    //List<AdViewModel> getListAd();
    int getMaxId();
    void InsertAd(String Q);
    void DeleteOldAd(int maxId);
}
