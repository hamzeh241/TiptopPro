package com.tiptap.tda_user.tiptap.main.activity.presenter;

import android.content.Context;
import com.tiptap.tda_user.tiptap.MVP_Splash;
import java.lang.ref.WeakReference;

public class Splash_Presenter
        implements MVP_Splash.ProvidedPresenterOps, MVP_Splash.RequiredPresenterOps{

    private WeakReference<MVP_Splash.RequiredViewOps> mView;
    private MVP_Splash.ProvidedModelOps mModel;

    public Splash_Presenter(MVP_Splash.RequiredViewOps view) {
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

    private MVP_Splash.RequiredViewOps getView() throws NullPointerException{
        if ( mView != null )
            return mView.get();
        else
            throw new NullPointerException("View is unavailable");
    }

    @Override
    public void setView(MVP_Splash.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }

    public void setModel(MVP_Splash.ProvidedModelOps model) {
        mModel = model;
        // start to load data
        //loadData();
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