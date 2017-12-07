package com.tiptap.tda_user.tiptap.main.activity.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.tiptap.tda_user.tiptap.MVP_Lesson;
import java.lang.ref.WeakReference;

public class Lesson_Presenter
        implements MVP_Lesson.ProvidedPresenterOps, MVP_Lesson.RequiredPresenterOps {

    private WeakReference<MVP_Lesson.RequiredViewOps> mView;
    private MVP_Lesson.ProvidedModelOps mModel;

    public Lesson_Presenter(MVP_Lesson.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        mView = null;
        mModel.onDestroy(isChangingConfiguration);
        if ( !isChangingConfiguration ) {
            mModel = null;
        }
    }

    private MVP_Lesson.RequiredViewOps getView() throws NullPointerException{
        if ( mView != null )
            return mView.get();
        else
            throw new NullPointerException("View is unavailable");
    }

    @Override
    public void setView(MVP_Lesson.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }

    public void setModel(MVP_Lesson.ProvidedModelOps model) {
        mModel = model;
        loadData();
    }

    private void loadData() {
        try {
            new AsyncTask<Void, Void, Boolean>() {
                @Override
                protected Boolean doInBackground(Void... params) {
                    // Load data from Language_Model
                    return mModel.loadData();
                }
                @Override
                protected void onPostExecute(Boolean result) {
                    try {
                        //if (!result) // Loading error
                            //getView().showToast(makeToast("Error loading data."));
                        //else // success
                        //getView().notifyDataSetChanged();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }.execute();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
//
//    @Override
//    public void NewActivity(final String Text) {
//        if ( Text != "" ) {
//            new AsyncTask<Void, Void, Boolean>() {
//                @Override
//                protected Boolean doInBackground(Void... params) {
//                    // Insert note in Language_Model, returning result
//                    return mModel.insertActivity(Text);
//                }
//
//                @Override
//                protected void onPostExecute(Boolean result) {
//                    try {
//                        if (result) {
//                           // getView().notifyDataSetChanged();
//                        } else {
//                            getView().showToast(makeToast("Error creating note"));
//                        }
//                    } catch (NullPointerException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.execute();
//        } else {
//            try {
//                getView().showToast(makeToast("Cannot add a blank note!"));
//            } catch (NullPointerException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public void Empty(){
        mModel.deleteALLActivity();
    }

    private Toast makeToast(String msg) {
        return Toast.makeText(getView().getAppContext(), msg, Toast.LENGTH_SHORT);
    }
//
//    @Override
//    public int getActivitesCount() {
//        return mModel.getActivitesCount();
//    }

   /* @Override
    public Activity getActivity(int position) {
        return mModel.getActivity(position);
    }*/

    @Override
    public Context getAppContext() {
        try {
            return getView().getAppContext();
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public Context getActivityContext() {
        try {
            return getView().getActivityContext();
        } catch (NullPointerException e) {
            return null;
        }
    }
}