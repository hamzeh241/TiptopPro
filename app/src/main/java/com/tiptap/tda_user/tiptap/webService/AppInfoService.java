package com.tiptap.tda_user.tiptap.webService;

import android.content.Context;
import android.database.Cursor;

public class AppInfoService implements IAppInfo {
    DBAdapter dbAdapter;
    Context context;
   // private List<AppInfo> AppList;
    //private List<AdViewModel> AdList;
    public AppInfoService(Context _conContext) {
        context=_conContext;
        dbAdapter=new DBAdapter(context);
        //AppList = new ArrayList<>();
        //AdList = new ArrayList<>();

    }

    /*@Override
    public List<AppInfo> getInfoApp() {
        try{
            String q="SELECT [AppInfo].[Version] FROM [AppInfo]";
            Cursor cursor=dbAdapter.ExecuteQ(q);
            int count=cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0; i < count; i++) {
                AppInfo  app = new AppInfo(cursor.getDouble(0));
                AppList.add(app);
                cursor.moveToNext();
            }}
        catch (Exception ex)
        {
            new PostError(context,ex.getMessage(), Utility.getMethodName()).postError();

        }
        return AppList;
    }

    @Override
    public List<AdViewModel> getListAd() {
        try{
            String q="SELECT [id],[AdText],[AdImage] FROM [Ad]";
            Cursor cursor=dbAdapter.ExecuteQ(q);
            int count=cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0; i < count; i++) {
                AdViewModel  app = new AdViewModel();
                app.setAdImage(cursor.getString(2));
                app.setAdText(cursor.getString(1));
                AdList.add(app);
                cursor.moveToNext();
            }}
        catch (Exception ex)
        {
            new PostError(context,ex.getMessage(),Utility.getMethodName()).postError();

        }
        return AdList;
    }*/

    @Override
    public int getMaxId() {
        String q="SELECT [id] FROM Ad ORDER BY id DESC LIMIT 1";
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
    public void InsertAd(String Q) {
        dbAdapter.ExecuteQ(Q);
    }

    @Override
    public void DeleteOldAd(int maxId) {
        String Q="delete from ad where id<="+maxId;
        dbAdapter.ExecuteQ(Q);
    }
}