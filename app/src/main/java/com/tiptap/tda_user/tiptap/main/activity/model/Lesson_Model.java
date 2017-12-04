package com.tiptap.tda_user.tiptap.main.activity.model;

import com.tiptap.tda_user.tiptap.MVP_Lesson;

public class Lesson_Model implements MVP_Lesson.ProvidedModelOps {

    private MVP_Lesson.RequiredPresenterOps mPresenter;
    //private DaoSession daoSession;
    //List<Activity> activities;

    public Lesson_Model(MVP_Lesson.RequiredPresenterOps presenter) {
        this.mPresenter = presenter;
        //DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mPresenter.getAppContext(),"db");
       // Database db = helper.getWritableDb();
        //helper.getReadableDatabase();
       // daoSession = new DaoMaster(db).newSession();
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        if (!isChangingConfiguration) {
            mPresenter = null;
         //   daoSession = null;
         //   activities = null;
        }
    }

    @Override
    public boolean loadData() {
       // activities = null;
      //  activities = getDaoSession().getActivityDao().loadAll();
      //  return activities != null;
        return true;
    }

   // @Override
   // public Activity getActivity(int position) {
     //   return activities.get(position);
   // }

    @Override
    public boolean insertActivity(String fun) {
       /* int id = getActivitesCount()+1;
        Long long_id = Long.valueOf(id);
        Long insert = getDaoSession().getActivityDao().insert(new Activity(long_id, id, fun, "aval", "note", "a1"));
        if (insert == long_id) {
            loadData();
            return true;
        }*/
        return false;
    }

    @Override
    public boolean deleteALLActivity() {
        //getDaoSession().getActivityDao().deleteAll();
        loadData();
        return true;
    }

    @Override
    public int getActivitesCount() {
        //if ( activities != null )
        //    return activities.size();
        return 0;
    }

   /* public int getActivityPosition(Activity act) {
        for (int i=0; i<activities.size(); i++){
            if ( act.getId_activity() == activities.get(i).getId_activity())
                return i;
        }
        return -1;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }*/
}