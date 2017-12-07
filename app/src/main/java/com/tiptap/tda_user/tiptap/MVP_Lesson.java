package com.tiptap.tda_user.tiptap;

import android.content.Context;
import android.widget.Toast;

public interface MVP_Lesson {

    interface RequiredViewOps {
        Context getAppContext();
        Context getActivityContext();
    }

    interface ProvidedPresenterOps {
        void onDestroy(boolean isChangingConfiguration);
        void setView(MVP_Lesson.RequiredViewOps view);
       // void NewActivity(String Text);
        //Activity getActivity(int position);
        //int getActivitesCount();
        //void Empty();
    }

    interface RequiredPresenterOps {
        Context getAppContext();
        Context getActivityContext();
    }

    interface ProvidedModelOps {
        void onDestroy(boolean isChangingConfiguration);
        boolean loadData();
        //boolean insertActivity(String fun);
        //Activity getActivity(int position);
        int getActivitesCount();
        boolean deleteALLActivity();
    }
}
