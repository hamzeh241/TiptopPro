package com.tiptap.tda_user.tiptap.webService.Interface;

import com.tiptap.tda_user.tiptap.webService.viewmodel.TbFunction;
import java.util.List;

public interface IFunction {
    String getMaxRowV_Function();
    int getMaxId_Function();
    int getCount_Function();
    void Insert_Function(String Q);
    List<TbFunction> getListFunction();
}