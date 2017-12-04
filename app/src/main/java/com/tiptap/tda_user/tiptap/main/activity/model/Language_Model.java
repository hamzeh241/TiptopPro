package com.tiptap.tda_user.tiptap.main.activity.model;

import com.tiptap.tda_user.tiptap.MVP_Language;

public class Language_Model implements MVP_Language.ProvidedModelOps {

    private MVP_Language.RequiredPresenterOps mPresenter;
    //List<Function> functions;

    public Language_Model(MVP_Language.RequiredPresenterOps presenter) {
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
           // daoSession = null;
           // functions = null;
        }
    }

   // public int getFunctionPosition(Function note) {
   //     for (int i=0; i<functions.size(); i++){
   //         if ( note.getId_function() == functions.get(i).getId_function())
   //             return i;
   //     }
   //     return -1;
   // }

   // public DaoSession getDaoSession() {
  //      return daoSession;
  //  }
}