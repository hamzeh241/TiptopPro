package com.tiptap.tda_user.tiptap.main.activity.view.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tiptap.tda_user.tiptap.MVP_Splash;
import com.tiptap.tda_user.tiptap.R;
import com.tiptap.tda_user.tiptap.common.SampleApp;
import com.tiptap.tda_user.tiptap.common.StateMaintainer;
import com.tiptap.tda_user.tiptap.di.module.Splash_Module;
import com.tiptap.tda_user.tiptap.main.activity.presenter.Splash_Presenter;
import com.tiptap.tda_user.tiptap.main.activity.view.language.Language;

import javax.inject.Inject;

public class Splash
        extends AppCompatActivity implements MVP_Splash.RequiredViewOps{
    //implements Animation.AnimationListener,

    TextView text;
    Animation animation;
    private static final String TAG = Splash.class.getSimpleName();

    @Inject
    public MVP_Splash.ProvidedPresenterOps mPresenter;

    private final StateMaintainer mStateMaintainer = new StateMaintainer( getFragmentManager(), Splash.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        setupViews();
        setupMVP();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy(isChangingConfigurations());
    }

    private void setupViews(){
        text = (TextView)findViewById(R.id.txt);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/GreatVibes.ttf");
        text.setTypeface(type);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Splash.this.finish();
                startActivity(new Intent(Splash.this, Language.class));
            }
        }, 3000);
        //animation = new TranslateAnimation(800,0,0,0);
        //animation.setDuration(4000);
        //animation.setFillAfter(true);
        //text.startAnimation(animation);
        //animation.setAnimationListener(this);
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
        mStateMaintainer.put(Splash_Presenter.class.getSimpleName(), mPresenter);
    }

    private void reinitialize() {
        Log.d(TAG, "reinitialize");
        mPresenter = mStateMaintainer.get(Splash_Presenter.class.getSimpleName());
        mPresenter.setView(this);
        if ( mPresenter == null )
            setupComponent();
    }

    private void setupComponent(){
        Log.d(TAG, "setupComponent");
        SampleApp.get(this)
                .getAppComponent()
                .getSplashComponent(new Splash_Module(this))
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

    /*@Override
    public void onAnimationRepeat(Animation animation) {}
    @Override
    public void onAnimationStart(Animation animation) {}
    @Override
    public void onAnimationEnd(Animation animation) {
        startActivity(new Intent(Splash.this, Language.class));
        Splash.this.finish();
    }*/
}