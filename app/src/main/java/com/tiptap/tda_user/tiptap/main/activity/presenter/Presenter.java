package com.tiptap.tda_user.tiptap.main.activity.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.Toast;
import com.appsng.greendaoapp.db.Function;
import com.tiptap.tda_user.tiptap.main.activity.mvp;
import com.tiptap.tda_user.tiptap.main.activity.view.recycler.NotesViewHolder;
import java.lang.ref.WeakReference;

public class Presenter implements mvp.ProvidedPresenterOps, mvp.RequiredPresenterOps {

    // View reference. We use as a WeakReference
    // because the Activity could be destroyed at any time
    // and we don't want to create a memory leak
    private WeakReference<mvp.RequiredViewOps> mView;
    // Model reference
    private mvp.ProvidedModelOps mModel;

    public Presenter(mvp.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        // View show be null every time onDestroy is called
        mView = null;
        // Inform Model about the event
        mModel.onDestroy(isChangingConfiguration);
        // Activity destroyed
        if ( !isChangingConfiguration ) {
            // Nulls Model when the Activity destruction is permanent
            mModel = null;
        }
    }

    private mvp.RequiredViewOps getView() throws NullPointerException{
        if ( mView != null )
            return mView.get();
        else
            throw new NullPointerException("View is unavailable");
    }

    @Override
    public void setView(mvp.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }

    public void setModel(mvp.ProvidedModelOps model) {
        mModel = model;
        // start to load data
        //loadData();
    }

    @Override
    public void NewFunction(final String Text) {
        //getView().showProgress();
        final String noteText = Text.toString();
        if ( !noteText.isEmpty() ) {
            new AsyncTask<Void, Void, Boolean>() {
                @Override
                protected Boolean doInBackground(Void... params) {
                    // Insert note in Model, returning result
                    return mModel.insertFunction(makeFunction(noteText));
                }

                @Override
                protected void onPostExecute(Boolean result) {
                    try {
                        if (result) {
                            //getView().notifyDataSetChanged();
                            //getView().showToast(makeToast("Note inserted."));
                        } else {
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }.execute();
        } else {
            try {
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public Function makeFunction(String noteText) {
        Function fun = new Function();
        fun.setTitle_function( noteText );
        return fun;

    }

    public void Empty(){
        mModel.deleteALLFunction();
    }

    private Toast makeToast(String msg) {
        return Toast.makeText(getView().getAppContext(), msg, Toast.LENGTH_SHORT);
    }

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