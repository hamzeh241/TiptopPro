package com.tiptap.tda_user.tiptap.webService.Interface;

import com.tiptap.tda_user.tiptap.webService.viewmodel.TbActivityDetail;
import java.util.List;

public interface IActivityDetail {
    String getMaxRowV_ActivityDetail();
    int getMaxId_ActivityDetail();
    int getCount_ActivityDetail(int aid);
    void Insert_ActivityDetail(String Q);
    List<TbActivityDetail> getListActivityDetail(int aid);
}