package com.tiptap.tda_user.tiptap.main.activity.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.appsng.greendaoapp.db.Function;
import com.tiptap.tda_user.tiptap.R;
import com.tiptap.tda_user.tiptap.main.activity.MVP_Main;
import com.tiptap.tda_user.tiptap.main.activity.view.recycler.NotesViewHolder;
import java.lang.ref.WeakReference;

public class MainPresenter implements MVP_Main.ProvidedPresenterOps, MVP_Main.RequiredPresenterOps {

    // View reference. We use as a WeakReference
    // because the Activity could be destroyed at any time
    // and we don't want to create a memory leak
    private WeakReference<MVP_Main.RequiredViewOps> mView;
    // Model reference
    private MVP_Main.ProvidedModelOps mModel;

    public MainPresenter(MVP_Main.RequiredViewOps view) {
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

    private MVP_Main.RequiredViewOps getView() throws NullPointerException{
        if ( mView != null )
            return mView.get();
        else
            throw new NullPointerException("View is unavailable");
    }

    @Override
    public void setView(MVP_Main.RequiredViewOps view) {
        mView = new WeakReference<>(view);
    }

    public void setModel(MVP_Main.ProvidedModelOps model) {
        mModel = model;
        // start to load data
        loadData();
    }

    private void loadData() {
        try {
            getView().showProgress();
            new AsyncTask<Void, Void, Boolean>() {
                @Override
                protected Boolean doInBackground(Void... params) {
                    // Load data from Model
                    return mModel.loadData();
                }

                @Override
                protected void onPostExecute(Boolean result) {
                    try {
                        getView().hideProgress();
                        if (!result) // Loading error
                            getView().showToast(makeToast("Error loading data."));
                        else // success
                            getView().notifyDataSetChanged();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }.execute();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void NewFunction(final String Text) {
        getView().showProgress();
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
                            getView().notifyDataSetChanged();
                            getView().showToast(makeToast("Note inserted."));
                        } else {
                            getView().hideProgress();
                            getView().showToast(makeToast("Error creating note [" + noteText + "]"));
                        }
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }.execute();
        } else {
            try {
                getView().showToast(makeToast("Cannot add a blank note!"));
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
    public int getNotesCount() {
        return mModel.getFunctionsCount();
    }

    @Override
    public NotesViewHolder createViewHolder(ViewGroup parent, int viewType) {
        NotesViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View viewTaskRow = inflater.inflate(R.layout.holder_notes, parent, false);
        viewHolder = new NotesViewHolder(viewTaskRow);

        return viewHolder;
    }

    @Override
    public void bindViewHolder(final NotesViewHolder holder, int position) {
        final Function function = mModel.getFunction(position);
        holder.text.setText( function.getTitle_function() );
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