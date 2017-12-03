package com.tiptap.tda_user.tiptap.common;

import android.app.Application;
import android.content.Context;
import com.tiptap.tda_user.tiptap.di.component.AppComponent;
import com.tiptap.tda_user.tiptap.di.component.DaggerAppComponent;
import com.tiptap.tda_user.tiptap.di.module.AppModule;
import com.tiptap.tda_user.tiptap.main.activity.MVP_Main;

public class SampleApp extends Application {

    public static final boolean ENCRYPTED = true;
    public MVP_Main.ProvidedPresenterOps mPresenter;


    public static SampleApp get(Context context) {
        return (SampleApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    private AppComponent appComponent;

    private void initAppComponent(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}