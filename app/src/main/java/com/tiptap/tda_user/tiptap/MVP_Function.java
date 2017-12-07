package com.tiptap.tda_user.tiptap;

import android.content.Context;
import android.support.v4.view.ViewPager;

import com.tiptap.tda_user.tiptap.main.activity.view.function_lesson.CardPagerAdapter_L;
import com.tiptap.tda_user.tiptap.main.activity.view.function_lesson.ShadowTransformer;

public interface MVP_Function {

    interface RequiredViewOps {
        Context getAppContext();
        Context getActivityContext();
    }

    interface ProvidedPresenterOps {
        void onDestroy(boolean isChangingConfiguration);
        void setView(RequiredViewOps view);
        int getFunctionsCount();
        //void NewFunction(String[][] Text,ViewPager mViewPager,CardPagerAdapter_L mCardAdapter,ShadowTransformer mCardShadowTransformer,Context _ctx, MVP_Function.ProvidedPresenterOps mPresenter);
        //Function getFunction(int position);
        //void Empty();
    }

    interface RequiredPresenterOps {
        Context getAppContext();
        Context getActivityContext();
    }

    interface ProvidedModelOps {
        void onDestroy(boolean isChangingConfiguration);
        boolean loadData();
        boolean insertFunction(String[][] funs, ViewPager mViewPager, CardPagerAdapter_L mCardAdapter, ShadowTransformer mCardShadowTransformer, Context _ctx, MVP_Function.ProvidedPresenterOps mPresenter);
        //Function getFunction(int position);
        int getFunctionsCount();
        boolean deleteALLFunction();
    }
}