package com.tiptap.tda_user.tiptap.di.component;

import com.tiptap.tda_user.tiptap.di.module.Lmodel;
import com.tiptap.tda_user.tiptap.di.scope.ActivityScope;
import com.tiptap.tda_user.tiptap.main.activity.view.Function;
import com.tiptap.tda_user.tiptap.main.activity.view.Language;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = Lmodel.class )
public interface LmodelComponent {
    Language inject(Language activity);
}
