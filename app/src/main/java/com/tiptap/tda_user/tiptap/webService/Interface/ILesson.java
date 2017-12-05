package com.tiptap.tda_user.tiptap.webService.Interface;

import com.tiptap.tda_user.tiptap.webService.viewmodel.TbLesson;
import java.util.List;

public interface ILesson {
    int getMaxId_Lesson();
    int getCount_Lesson();
    void Insert_Lesson(String Q);
    List<TbLesson> getListLesson();
}