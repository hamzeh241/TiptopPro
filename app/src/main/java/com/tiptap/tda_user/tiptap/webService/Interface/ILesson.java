package com.tiptap.tda_user.tiptap.webService.Interface;

import com.tiptap.tda_user.tiptap.webService.viewmodel.TbLesson;
import java.util.List;

public interface ILesson {
    String getMaxRowV_Lesson();
    int getMaxId_Lesson();
    int getCount_Lesson(int fid);
    void Insert_Lesson(String Q);
    List<TbLesson> getListLesson(int fid);
}