package com.tiptap.tda_user.tiptap.di.component;

import android.app.Application;
import com.tiptap.tda_user.tiptap.di.module.AppModule;
import com.tiptap.tda_user.tiptap.di.module.MainActivityModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Application application();
    MainActivityComponent getMainComponent(MainActivityModule module);
    //LmodelComponent getMComponent(Lmodel module);
}