package com.tiptap.tda_user.tiptap.webService.Cls;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.tiptap.tda_user.tiptap.main.activity.view.function_lesson.CardItem;
import com.tiptap.tda_user.tiptap.main.activity.view.function_lesson.CardPagerAdapter_F;
import com.tiptap.tda_user.tiptap.main.activity.view.function_lesson.ShadowTransformer;
import com.tiptap.tda_user.tiptap.webService.DB.BaseSetingApi;
import com.tiptap.tda_user.tiptap.webService.Interface.IFunction;
import com.tiptap.tda_user.tiptap.webService.Service.Service_Function;

public class Set_Function extends BaseSetingApi {

    Context _context;
    IFunction iFunction;
    ViewPager mViewPager;
    CardPagerAdapter_F mCardAdapter;
    ShadowTransformer mCardShadowTransformer;

    public Set_Function(Context context, ViewPager viewPager, CardPagerAdapter_F cardAdapter, ShadowTransformer shadowTransformer) {
        _context = context;
        iFunction = new Service_Function(context);
        mViewPager = viewPager;
        mCardAdapter = cardAdapter;
        mCardShadowTransformer = shadowTransformer;
    }

    public void load() {
        for (int i = 0; i < iFunction.getCount_Function(); i++) {
            mCardAdapter.addCardItem(new CardItem(iFunction.getListFunction().get(i).get_id(), iFunction.getListFunction().get(i).getTitle()));
        }
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mCardShadowTransformer.enableScaling(true);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }
}