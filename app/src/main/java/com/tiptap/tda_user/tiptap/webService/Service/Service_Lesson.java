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
    public int getCount_Lesson() {
        String q="SELECT Count([_id]) as x FROM TbLesson";
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
    public List<TbLesson> getListLesson() {
        try{
            String q = "SELECT [_id],[Title],[RowVersion] FROM [TbLesson]";
            Cursor cursor = dbAdapter.ExecuteQ(q);
            int count=cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0; i < count; i++) {
                TbLesson app = new TbLesson();
                //app.setTitle(cursor.getString(1));
                //app.setRowVersion(cursor.getString(2));
                LList.add(app);
                cursor.moveToNext();
            }}
        catch (Exception ex)
        {
            new PostError(context,ex.getMessage(),getMethodName()).postError();

        }
        return LList;
    }

    public String GetMaxRowV() {
        String q = "SELECT [RowVersion] FROM TbLesson ORDER BY RowVersion DESC LIMIT 1";
        Cursor cursor = dbAdapter.ExecuteQ(q);
        int count = cursor.getCount();
        cursor.moveToFirst();
        String id = "0x0";
        for (int i = 0; i < count; i++) {
            id = cursor.getString(0);
        }
        return id;
    }
}