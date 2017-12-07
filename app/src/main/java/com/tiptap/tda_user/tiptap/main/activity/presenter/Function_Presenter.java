package com.tiptap.tda_user.tiptap.main.activity.presenter;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.tiptap.tda_user.tiptap.MVP_Function;
import java.lang.ref.WeakReference;

public class Function_Presenter
        implements MVP_Function.ProvidedPresenterOps, MVP_Function.RequiredPresenterOps {

    private WeakReference<MVP_Function.RequiredViewOps> mView;
    private MVP_Function.ProvidedModelOps mModel;

    public Function_Presenter(MVP_Function.RequiredViewOps view) {
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

    private MVP_Function.RequiredViewOps getView() throws NullPointerException{
        if ( mView != null )
            return mView.get();
        else
            throw new NullPointerException("View is unavailable");
    }

    @Override
    public void setView(MVP_Function.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }

    public void setModel(MVP_Function.ProvidedModelOps model) {
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

    /*@Override
    public void NewFunction(final String[][] F, final ViewPager mViewPager, final CardPagerAdapter_L mCardAdapter, final ShadowTransformer mCardShadowTransformer, final Context _ctx, final MVP_Function.ProvidedPresenterOps mPresenter) {
        mModel.insertFunction(F, mViewPager, mCardAdapter,  mCardShadowTransformer, _ctx, mPresenter);
//        new AsyncTask<Void, Void, Boolean>() {
//            @Override
//            protected Boolean doInBackground(Void... params) {
//                // Insert note in Language_Model, returning result
//                return mModel.insertFunction(F, mViewPager, mCardAdapter,  mCardShadowTransformer, _ctx);
//            }
//
//            @Override
//            protected void onPostExecute(Boolean result) {
//                try {
//                    if (result) {
//                        //getView().notifyDataSetChanged();
//                    } else {
//                        getView().showToast(makeToast("Error creating note"));
//                    }
//                } catch (NullPointerException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.execute();
    }

    @Override
    public Function getFunction(int position) {
        return mModel.getFunction(position);
    }*/

    public void Empty(){
        mModel.deleteALLFunction();
    }

    private Toast makeToast(String msg) {
        return Toast.makeText(getView().getAppContext(), msg, Toast.LENGTH_SHORT);
    }

    @Override
    public int getFunctionsCount() {
        return mModel.getFunctionsCount();
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