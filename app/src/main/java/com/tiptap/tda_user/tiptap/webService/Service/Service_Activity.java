package com.tiptap.tda_user.tiptap.webService.Service;

import android.content.Context;
import android.database.Cursor;
import com.tiptap.tda_user.tiptap.webService.DB.DBAdapter;
import com.tiptap.tda_user.tiptap.webService.DB.PostError;
import com.tiptap.tda_user.tiptap.webService.Interface.IActivity;
import com.tiptap.tda_user.tiptap.webService.viewmodel.TbActivity;
import java.util.ArrayList;
import java.util.List;
import static com.tiptap.tda_user.tiptap.common.SampleApp.getMethodName;

public class Service_Activity implements IActivity {

    DBAdapter dbAdapter;
    Context context;
    private List<TbActivity> AList;

    public Service_Activity(Context _conContext) {
        context=_conContext;
        dbAdapter=new DBAdapter(context);
        AList = new ArrayList<>();
    }

    @Override
    public String getMaxRowV_Activity() {
        String q="SELECT MAX(RowVersion) as RowVersion FROM TbActivity";
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
    public int getMaxId_Activity() {
        String q="SELECT [_id] FROM TbActivity ORDER BY _id DESC LIMIT 1";
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
    public int getCount_Activity(int lid) {
        String q="SELECT Count([_id]) as x FROM TbActivity where Id_Lesson = "+ lid;
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
    public void Insert_Activity(String Q) {
        dbAdapter.ExecuteQ(Q);
    }

    @Override
    public List<TbActivity> getListActivity(int lid) {
        try{
            String q = "SELECT [_id],[Id_Lesson],[ActivityNumber],[Id_ActivityType],[Title1],[Title2],[Path1],[Path2],[IsNote],[RowVersion] FROM [TbActivity] where Id_Lesson = "+ lid;
            Cursor cursor = dbAdapter.ExecuteQ(q);
            int count=cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0; i < count; i++) {
                TbActivity app = new TbActivity();
                app.set_id(Integer.parseInt(cursor.getString(0)));
                app.setId_Lesson(Integer.parseInt(cursor.getString(1)));
                app.setActivityNumber(Integer.parseInt(cursor.getString(2)));
                app.setId_ActivityType(Integer.parseInt(cursor.getString(3)));
                app.setTitle1(cursor.getString(4));
                app.setTitle2(cursor.getString(5));
                app.setPath1(cursor.getString(6));
                app.setPath2(cursor.getString(7));
                app.setIsNote(Boolean.parseBoolean(cursor.getString(8)));
                app.setRowVersion(cursor.getString(9));
                AList.add(app);
                cursor.moveToNext();
            }}
        catch (Exception ex) {
            new PostError(context,ex.getMessage(),getMethodName()).postError();
        }
        return AList;
    }
}