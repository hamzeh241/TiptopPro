package com.tiptap.tda_user.tiptap.main.activity.model;
import com.tiptap.tda_user.tiptap.MVP_Splash;

public class Splash_Model implements MVP_Splash.ProvidedModelOps {

    private MVP_Splash.RequiredPresenterOps mPresenter;

    public Splash_Model(MVP_Splash.RequiredPresenterOps presenter) {
        this.mPresenter = presenter;
        //DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mPresenter.getAppContext(),"db");
        //Database db = helper.getWritableDb();
        //helper.getReadableDatabase();
        //daoSession = new DaoMaster(db).newSession();
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        if (!isChangingConfiguration) {
            mPresenter = null;
        }
    }

   // public DaoSession getDaoSession() {
     //   return daoSession;
    //}
}
