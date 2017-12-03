package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.di.scope.ActivityScope;
import com.tiptap.tda_user.tiptap.main.activity.model.Model;
import com.tiptap.tda_user.tiptap.main.activity.mvp;
import com.tiptap.tda_user.tiptap.main.activity.presenter.Presenter;
import com.tiptap.tda_user.tiptap.main.activity.view.Language;

import dagger.Module;
import dagger.Provides;

@Module
public class Lmodel {

    private Language activity;

    public Lmodel(Language activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Language providesLanguage() {
        return activity;
    }

    @Provides
    @ActivityScope
    mvp.ProvidedPresenterOps providedPresenterOps() {
        Presenter presenter = new Presenter( activity );
        Model model = new Model( presenter );
        presenter.setModel( model );
        return presenter;
    }
}
