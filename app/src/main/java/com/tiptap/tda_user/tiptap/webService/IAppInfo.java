package com.tiptap.tda_user.tiptap.webService;

import com.tiptap.tda_user.tiptap.webService.viewmodel.FunctionViewModel;
import java.util.List;

public interface IAppInfo {
    List<AppInfo> getInfoApp();
    List<FunctionViewModel> getListFun();
    int getMaxId();
    void InsertAd(String Q);
    void DeleteOldAd(int maxId);
}
