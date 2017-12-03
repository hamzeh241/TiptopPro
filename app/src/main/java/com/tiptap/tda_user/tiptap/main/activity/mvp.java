package com.tiptap.tda_user.tiptap.main.activity;

import android.content.Context;
import android.widget.Toast;
import com.appsng.greendaoapp.db.Function;
import com.tiptap.tda_user.tiptap.main.activity.view.Language;

public interface mvp {

    interface RequiredViewOps {
        Context getAppContext();
        Context getActivityContext();
    }

    interface ProvidedPresenterOps {
        void onDestroy(boolean isChangingConfiguration);
        void setView(mvp.RequiredViewOps view);
        void NewFunction(String Text);
        void Empty();
    }

    interface RequiredPresenterOps {
        Context getAppContext();
        Context getActivityContext();
    }

    interface ProvidedModelOps {
        void onDestroy(boolean isChangingConfiguration);
        boolean insertFunction(Function function);
        int getFunctionsCount();
        boolean deleteALLFunction();
    }
}