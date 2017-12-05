package com.tiptap.tda_user.tiptap.webService.Interface;

import com.tiptap.tda_user.tiptap.webService.viewmodel.TbActivity;
import java.util.List;

public interface IActivity {
    int getMaxId_Activity();
    int getCount_Activity();
    void Insert_Activity(String Q);
    List<TbActivity> getListActivity();
}
