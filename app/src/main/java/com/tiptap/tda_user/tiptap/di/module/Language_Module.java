package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.MVP_Language;
import com.tiptap.tda_user.tiptap.di.scope.ActivityScope;
import com.tiptap.tda_user.tiptap.main.activity.model.Language_Model;
import com.tiptap.tda_user.tiptap.main.activity.presenter.Language_Presenter;
import com.tiptap.tda_user.tiptap.main.activity.view.language.Language;
import dagger.Module;
import dagger.Provides;

@Module
public class Language_Module {

    private Language activity;

    public Language_Module(Language activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Language providesLanguageActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    MVP_Language.ProvidedPresenterOps providedPresenterOps() {
        Language_Presenter presenter = new Language_Presenter( activity );
        Language_Model model = new Language_Model( presenter );
        presenter.setModel( model );
        return presenter;
    }
}
