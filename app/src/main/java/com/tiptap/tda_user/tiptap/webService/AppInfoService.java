package com.tiptap.tda_user.tiptap.webService;

import android.content.Context;
import android.database.Cursor;
import com.tiptap.tda_user.tiptap.webService.viewmodel.FunctionViewModel;
import java.util.ArrayList;
import java.util.List;
import static com.tiptap.tda_user.tiptap.common.SampleApp.getMethodName;

public class AppInfoService implements IAppInfo {

    DBAdapter dbAdapter;
    Context context;
    private List<AppInfo> AppList;
    private List<FunctionViewModel> FList;

    public AppInfoService(Context _conContext) {
        context=_conContext;
        dbAdapter=new DBAdapter(context);
        AppList = new ArrayList<>();
        FList = new ArrayList<>();

    }

    @Override
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
            new PostError(context,ex.getMessage(), getMethodName()).postError();

        }
        return AppList;
    }

    @Override
    public List<FunctionViewModel> getListFun() {
        try{
            String q = "SELECT [id_function],[title_function],[row_version] FROM [Function]";
            Cursor cursor = dbAdapter.ExecuteQ(q);
            int count=cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0; i < count; i++) {
                FunctionViewModel  app = new FunctionViewModel();
                app.setTitle_function(cursor.getString(1));
                app.setRow_version(cursor.getString(2));
                FList.add(app);
                cursor.moveToNext();
            }}
        catch (Exception ex)
        {
            new PostError(context,ex.getMessage(),getMethodName()).postError();

        }
        return FList;
    }


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