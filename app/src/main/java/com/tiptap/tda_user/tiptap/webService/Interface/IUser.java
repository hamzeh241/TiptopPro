package com.tiptap.tda_user.tiptap.webService.Interface;

import com.tiptap.tda_user.tiptap.webService.viewmodel.TbUser;
import java.util.List;

public interface IUser {
    String getMaxRowV_User();
    int getMaxId_User();
    int getCount_User();
    void Insert_User(String Q);
    List<TbUser> getListUser();
}
