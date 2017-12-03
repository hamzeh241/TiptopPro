package com.tiptap.tda_user.tiptap.main.activity.model;

import com.appsng.greendaoapp.db.DaoMaster;
import com.appsng.greendaoapp.db.DaoSession;
import com.appsng.greendaoapp.db.Function;
import com.tiptap.tda_user.tiptap.main.activity.MVP_Main;
import org.greenrobot.greendao.database.Database;
import java.util.List;

public class MainModel implements MVP_Main.ProvidedModelOps {

    private MVP_Main.RequiredPresenterOps mPresenter;
    private DaoSession daoSession;
    List<Function> functions;

    public MainModel(MVP_Main.RequiredPresenterOps presenter) {
        this.mPresenter = presenter;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mPresenter.getAppContext(),"db");
        Database db = helper.getWritableDb();
        helper.getReadableDatabase();
        daoSession = new DaoMaster(db).newSession();
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        if (!isChangingConfiguration) {
            mPresenter = null;
            daoSession = null;
            functions = null;
        }
    }

    @Override
    public boolean loadData() {
        functions = null;
        functions = getDaoSession().getFunctionDao().loadAll();
        return functions != null;
    }

    @Override
    public Function getFunction(int position) {
        return functions.get(position);
    }

    @Override
    public boolean insertFunction(Function function) {
        int id = getFunctionsCount()+1;
        Long long_id = Long.valueOf(id);
        Long insert = getDaoSession().getFunctionDao().insert(new Function(long_id, id, function.getTitle_function(), "1"));
        if (insert == long_id) {
            loadData();
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteALLFunction() {
        getDaoSession().getFunctionDao().deleteAll();
        loadData();
        return true;
    }

    public int getFunctionPosition(Function note) {
        for (int i=0; i<functions.size(); i++){
            if ( note.getId_function() == functions.get(i).getId_function())
                return i;
        }
        return -1;
    }

    @Override
    public int getFunctionsCount() {
        if ( functions != null )
            return functions.size();
        return 0;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}