package com.tiptap.tda_user.tiptap.main.activity;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import com.appsng.greendaoapp.db.Function;
import com.tiptap.tda_user.tiptap.main.activity.view.recycler.NotesViewHolder;

public interface MVP_Main {

    interface RequiredViewOps {
        Context getAppContext();
        Context getActivityContext();
        void showToast(Toast toast);
        void showProgress();
        void hideProgress();
        void notifyDataSetChanged();
    }

    interface ProvidedPresenterOps {
        void onDestroy(boolean isChangingConfiguration);
        void setView(RequiredViewOps view);
        NotesViewHolder createViewHolder(ViewGroup parent, int viewType);
        void bindViewHolder(NotesViewHolder holder, int position);
        int getNotesCount();
        void NewFunction(String Text);
        void Empty();
    }

    interface RequiredPresenterOps {
        Context getAppContext();
        Context getActivityContext();
    }

    interface ProvidedModelOps {
        void onDestroy(boolean isChangingConfiguration);
        boolean loadData();
        boolean insertFunction(Function function);
        Function getFunction(int position);
        int getFunctionsCount();
        boolean deleteALLFunction();
    }
}