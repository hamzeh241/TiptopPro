package com.tiptap.tda_user.tiptap.webService.Service;

import android.content.Context;
import android.database.Cursor;
import com.tiptap.tda_user.tiptap.webService.DB.DBAdapter;
import com.tiptap.tda_user.tiptap.webService.DB.PostError;
import com.tiptap.tda_user.tiptap.webService.Interface.ILesson;
import com.tiptap.tda_user.tiptap.webService.viewmodel.TbLesson;
import java.util.ArrayList;
import java.util.List;
import static com.tiptap.tda_user.tiptap.common.SampleApp.getMethodName;

public class Service_Lesson implements ILesson {

    DBAdapter dbAdapter;
    Context context;
    private List<TbLesson> LList;

    public Service_Lesson(Context _conContext) {
        context=_conContext;
        dbAdapter=new DBAdapter(context);
        LList = new ArrayList<>();
    }


    @Override
    public String getMaxRowV_Lesson() {
        String q="SELECT MAX(RowVersion) as RowVersion FROM TbLesson";
        Cursor cursor=dbAdapter.ExecuteQ(q);
        int count=cursor.getCount();
        cursor.moveToFirst();
        String id="0x0";
        for (int i = 0; i < count; i++) {
            id=cursor.getString(0);
        }
        if(null==id)
            id="0x0";
        return id;
    }

    @Override
    public int getMaxId_Lesson() {
        String q="SELECT [_id] FROM TbLesson ORDER BY _id DESC LIMIT 1";
        Cursor cursor=dbAdapter.ExecuteQ(q);
        int count=cursor.getCount();
        cursor.moveToFirst();
        int id=0;
        for (int i = 0; i < count; i++) {
            id=cursor.getInt(0);
        }
        return id;
    }

    @Override
    public int getCount_Lesson(int fid) {
        String q="SELECT Count([_id]) as x FROM TbLesson where Id_Function = "+ fid;
        Cursor cursor=dbAdapter.ExecuteQ(q);
        int count=cursor.getCount();
        cursor.moveToFirst();
        int id=0;
        for (int i = 0; i < count; i++) {
            id=cursor.getInt(0);
        }
        return id;
    }

    @Override
    public void Insert_Lesson(String Q) {
        dbAdapter.ExecuteQ(Q);
    }

    @Override
    public List<TbLesson> getListLesson(int fid) {
        try{
            String q = "SELECT [_id],[Id_Function],[LessonNumber],[RowVersion] FROM [TbLesson] where Id_Function = "+ fid;
            Cursor cursor = dbAdapter.ExecuteQ(q);
            int count=cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0; i < count; i++) {
                TbLesson app = new TbLesson();
                app.set_id(Integer.parseInt(cursor.getString(0)));
                app.setId_Function(Integer.parseInt(cursor.getString(1)));
                app.setLessonNumber(Integer.parseInt(cursor.getString(2)));
                app.setRowVersion(cursor.getString(3));
                LList.add(app);
                cursor.moveToNext();
            }}
        catch (Exception ex)
        {
            new PostError(context,ex.getMessage(),getMethodName()).postError();

        }
        return LList;
    }
}