package com.tiptap.tda_user.tiptap.di.component;

import com.tiptap.tda_user.tiptap.di.module.MainActivityModule;
import com.tiptap.tda_user.tiptap.di.scope.ActivityScope;
import com.tiptap.tda_user.tiptap.main.activity.view.Function;
import com.tiptap.tda_user.tiptap.main.activity.view.Language;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = MainActivityModule.class )
public interface MainActivityComponent {
    Function inject(Function activity);
}

