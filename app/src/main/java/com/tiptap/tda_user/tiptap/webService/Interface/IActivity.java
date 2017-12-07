package com.tiptap.tda_user.tiptap.webService.Interface;

import com.tiptap.tda_user.tiptap.webService.viewmodel.TbActivity;
import java.util.List;

public interface IActivity {
    String getMaxRowV_Activity();
    int getMaxId_Activity();
    int getCount_Activity(int lid);
    void Insert_Activity(String Q);
    List<TbActivity> getListActivity(int lid);
}
