package com.tiptap.tda_user.tiptap.di.component;

import com.tiptap.tda_user.tiptap.di.scope.ActivityScope;
import com.tiptap.tda_user.tiptap.main.activity.view.Function;
import com.tiptap.tda_user.tiptap.main.activity.view.Language;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = LmodelComponent.class )
public interface LmodelComponent {
    Language inject(Language activity);
}
