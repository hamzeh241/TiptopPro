package com.tiptap.tda_user.tiptap.webService.Interface;

import com.tiptap.tda_user.tiptap.webService.viewmodel.TbGlossary;
import java.util.List;

public interface IGlossary {
    String getMaxRowV_Glossary();
    int getMaxId_Glossary();
    int getCount_Glossary();
    void Insert_Glossary(String Q);
    List<TbGlossary> getListGlossary();
}
