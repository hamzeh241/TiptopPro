package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.MVP_Function;
import com.tiptap.tda_user.tiptap.di.scope.ActivityScope;
import com.tiptap.tda_user.tiptap.main.activity.model.Function_Model;
import com.tiptap.tda_user.tiptap.main.activity.presenter.Function_Presenter;
import com.tiptap.tda_user.tiptap.main.activity.view.function.Function;
import dagger.Module;
import dagger.Provides;

@Module
public class Function_Module {

    private Function activity;

    public Function_Module(Function activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Function providesMainActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    MVP_Function.ProvidedPresenterOps providedPresenterOps() {
        Function_Presenter presenter = new Function_Presenter( activity );
        Function_Model model = new Function_Model( presenter );
        presenter.setModel( model );
        return presenter;
    }
}