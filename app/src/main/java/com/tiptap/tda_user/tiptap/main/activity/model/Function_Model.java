package com.tiptap.tda_user.tiptap.main.activity.model;

import android.content.Context;
import android.support.v4.view.ViewPager;
import com.tiptap.tda_user.tiptap.MVP_Function;
import com.tiptap.tda_user.tiptap.main.activity.view.function.CardPagerAdapter;
import com.tiptap.tda_user.tiptap.main.activity.view.function.ShadowTransformer;
import com.tiptap.tda_user.tiptap.main.activity.view.splash.Splash;
import com.tiptap.tda_user.tiptap.webService.SQLite;

public class Function_Model implements MVP_Function.ProvidedModelOps {

    private MVP_Function.RequiredPresenterOps mPresenter;

    public Function_Model(MVP_Function.RequiredPresenterOps presenter) {
        this.mPresenter = presenter;
        Splash.sqlite = new SQLite(mPresenter.getAppContext());
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        if (!isChangingConfiguration) {
            mPresenter = null;
        }
    }

    @Override
    public boolean loadData() {
        return false;
    }

    @Override
    public boolean insertFunction(String[][] funs, ViewPager mViewPager, CardPagerAdapter mCardAdapter, ShadowTransformer mCardShadowTransformer, Context _ctx, MVP_Function.ProvidedPresenterOps mPresenter) {
        return false;
    }

    @Override
    public int getFunctionsCount() {
        return 0;
    }

    @Override
    public boolean deleteALLFunction() {
        return false;
    }

   /* @Override
    public String GetMaxRowV() {
        String q="SELECT [RowVersion] FROM function ORDER BY RowVersion DESC LIMIT 1";
        Cursor cursor = dbAdapter.ExecuteQ(q);
        int count=cursor.getCount();
        cursor.moveToFirst();
        String id = "0x0";
        for (int i = 0; i < count; i++) {
            id=cursor.getString(0);
        }
        return id;
    }

    @Override
    public String GetMaxId() {
        String q="SELECT [id] FROM function ORDER BY id DESC LIMIT 1";
        Cursor cursor = dbAdapter.ExecuteQ(q);
        int count=cursor.getCount();
        cursor.moveToFirst();
        String id = "0x0";
        for (int i = 0; i < count; i++) {
            id=cursor.getString(0);
        }
        return id;
    }

    @Override
    public boolean insertFunction(String id, String title) {
        Splash.sqlite.open();
        Splash.sqlite.insert_function(id,title,"1");
        Splash.sqlite.close();
        //int id = getFunctionsCount()+1;
        //Long long_id = Long.valueOf(id);
        //Function[] functions = new Function[funs.length];
        //Function func;
        //for (int i = 0; i < funs.length; i++) {
        //int i=0;
        //func = new Function(long_id, funs[i][0], funs[i][1], "a1");
        // functions[i] = func;
        //}
        //getDaoSession().getFunctionDao().insert(func);
        //loadData();



        return true;
    }

    @Override
    public boolean updateFunction(String id, String title) {
        Splash.sqlite.open();
        Splash.sqlite.insert_function(id,title,"1");
        Splash.sqlite.close();
        //int id = getFunctionsCount()+1;
        //Long long_id = Long.valueOf(id);
        //Function[] functions = new Function[funs.length];
        //Function func;
        //for (int i = 0; i < funs.length; i++) {
        //int i=0;
        //func = new Function(long_id, funs[i][0], funs[i][1], "a1");
        // functions[i] = func;
        //}
        //getDaoSession().getFunctionDao().insert(func);
        //loadData();

        return true;
    }

    @Override
    public String getFunction(int position) {
        //return functions.get(position);
    }*/

}