package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.di.scope.ActivityScope;
import com.tiptap.tda_user.tiptap.main.activity.MVP_Main;
import com.tiptap.tda_user.tiptap.main.activity.model.MainModel;
import com.tiptap.tda_user.tiptap.main.activity.presenter.MainPresenter;
import com.tiptap.tda_user.tiptap.main.activity.view.Function;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    private Function activity;

    public MainActivityModule(Function activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Function providesMainActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    MVP_Main.ProvidedPresenterOps providedPresenterOps() {
        MainPresenter presenter = new MainPresenter( activity );
        MainModel model = new MainModel( presenter );
        presenter.setModel( model );
        return presenter;
    }
}