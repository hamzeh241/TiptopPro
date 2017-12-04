package com.tiptap.tda_user.tiptap.main.activity.view.lesson;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import com.google.common.collect.Lists;
import com.tiptap.tda_user.tiptap.MVP_Lesson;
import com.tiptap.tda_user.tiptap.R;
import com.tiptap.tda_user.tiptap.common.SampleApp;
import com.tiptap.tda_user.tiptap.common.StateMaintainer;
import com.tiptap.tda_user.tiptap.di.module.Lesson_Module;
import com.tiptap.tda_user.tiptap.main.activity.presenter.Lesson_Presenter;
import java.util.List;
import javax.inject.Inject;
import github.chenupt.multiplemodel.viewpager.ModelPagerAdapter;
import github.chenupt.multiplemodel.viewpager.PagerModelManager;
import github.chenupt.springindicator.SpringIndicator;
import github.chenupt.springindicator.viewpager.ScrollerViewPager;

public class Lesson
        extends AppCompatActivity implements MVP_Lesson.RequiredViewOps{

    ScrollerViewPager viewPager;
    public static String function;
    private static final String TAG = Lesson.class.getSimpleName();

    @Inject
    public MVP_Lesson.ProvidedPresenterOps mPresenter;

    private final StateMaintainer mStateMaintainer = new StateMaintainer( getFragmentManager(), Lesson.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson);

        setupViews();
        setupMVP();
        insert();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy(isChangingConfigurations());
    }

    private void setupViews(){
        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);

        PagerModelManager manager = new PagerModelManager();
        switch (function){
            case "Function 1":
                manager.addCommonFragment(GuideFragment.class, getBgRes_3(4,3,3), getLesson_3());
                break;
            case "Function 2":
                manager.addCommonFragment(GuideFragment.class, getBgRes_3(3,4,3), getLesson_3());
                break;
        }
        ModelPagerAdapter adapter = new ModelPagerAdapter(getSupportFragmentManager(), manager);
        viewPager.setAdapter(adapter);
        viewPager.fixScrollSpeed();

        // just set viewPager
        springIndicator.setViewPager(viewPager);
    }

    // Number of lesson for each function
    private List<String> getLesson_2(){
        return Lists.newArrayList("1", "2");
    }
    private List<String> getLesson_3(){
        return Lists.newArrayList("1", "2", "3");
    }
    private List<String> getLesson_4(){
        return Lists.newArrayList("1", "2", "3", "4");
    }

    // Number of activity for each lesson
    private List<Integer> getBgRes_2(int a, int b){
        return Lists.newArrayList(a, b);
    }
    private List<Integer> getBgRes_3(int a, int b, int c){
        return Lists.newArrayList(a, b, c);
    }
    private List<Integer> getBgRes_4(int a, int b, int c, int d){
        return Lists.newArrayList(a, b, c, d);
    }

    private void setupMVP(){
        if ( mStateMaintainer.firstTimeIn() ) {
            initialize();
        } else {
            reinitialize();
        }
    }

    private void initialize(){
        Log.d(TAG, "initialize");
        setupComponent();
        mStateMaintainer.put(Lesson_Presenter.class.getSimpleName(), mPresenter);
    }

    private void reinitialize() {
        Log.d(TAG, "reinitialize");
        mPresenter = mStateMaintainer.get(Lesson_Presenter.class.getSimpleName());
        mPresenter.setView(this);
        if ( mPresenter == null )
            setupComponent();
    }

    private void setupComponent(){
        Log.d(TAG, "setupComponent");
        SampleApp.get(this)
                .getAppComponent()
                .getLessonComponent(new Lesson_Module(this))
                .inject(this);
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public void showToast(Toast toast) {
        toast.show();
    }

    public void insert(){
      //  mPresenter.Empty();
     //   mPresenter.NewActivity(a1+"");
    }
}