package com.tiptap.tda_user.tiptap.webService.Cls;

import android.content.Context;
import android.support.v4.view.ViewPager;
import com.tiptap.tda_user.tiptap.main.activity.view.function_lesson.CardItem;
import com.tiptap.tda_user.tiptap.main.activity.view.function_lesson.CardPagerAdapter_L;
import com.tiptap.tda_user.tiptap.main.activity.view.function_lesson.ShadowTransformer;
import com.tiptap.tda_user.tiptap.webService.DB.BaseSetingApi;
import com.tiptap.tda_user.tiptap.webService.Interface.ILesson;
import com.tiptap.tda_user.tiptap.webService.Service.Service_Lesson;

public class Set_Lesson extends BaseSetingApi {

    Context _context;
    int _id;
    ILesson iLesson;
    ViewPager mViewPager;
    CardPagerAdapter_L mCardAdapter;
    ShadowTransformer mCardShadowTransformer;

    public Set_Lesson(Context context,int id, ViewPager viewPager, CardPagerAdapter_L cardAdapter, ShadowTransformer shadowTransformer) {
        _context = context;
        _id = id;
        iLesson = new Service_Lesson(context);
        mViewPager = viewPager;
        mCardAdapter = cardAdapter;
        mCardShadowTransformer = shadowTransformer;
    }

    public void load() {
        if(iLesson.getCount_Lesson(_id) != 0){
            for (int i = 0; i < iLesson.getCount_Lesson(_id); i++) {
                mCardAdapter.addCardItem(new CardItem(iLesson.getListLesson(_id).get(i).get_id(),iLesson.getListLesson(_id).get(i).getLessonNumber()+""));
            }
            mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
            mCardShadowTransformer.enableScaling(true);
            mViewPager.setAdapter(mCardAdapter);
            mViewPager.setPageTransformer(false, mCardShadowTransformer);
            mViewPager.setOffscreenPageLimit(3);
        }
    }
}