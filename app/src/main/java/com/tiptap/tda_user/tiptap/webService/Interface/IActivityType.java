package com.tiptap.tda_user.tiptap.webService.Interface;

import com.tiptap.tda_user.tiptap.webService.viewmodel.TbActivityType;
import java.util.List;

public interface IActivityType {
    int getMaxId_ActivityType();
    int getCount_ActivityType();
    void Insert_ActivityType(String Q);
    List<TbActivityType> getListActivityType();
}
