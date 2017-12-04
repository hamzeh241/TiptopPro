package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.MVP_Lesson;
import com.tiptap.tda_user.tiptap.di.scope.ActivityScope;
import com.tiptap.tda_user.tiptap.main.activity.model.Lesson_Model;
import com.tiptap.tda_user.tiptap.main.activity.presenter.Lesson_Presenter;
import com.tiptap.tda_user.tiptap.main.activity.view.lesson.Lesson;

import dagger.Module;
import dagger.Provides;

@Module
public class Lesson_Module {

    private Lesson activity;

    public Lesson_Module(Lesson activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Lesson providesLessonActivity() {
        return activity;
    }

    @Provides
    @ActivityScope
    MVP_Lesson.ProvidedPresenterOps providedPresenterOps() {
        Lesson_Presenter presenter = new Lesson_Presenter( activity );
        Lesson_Model model = new Lesson_Model( presenter );
        presenter.setModel( model );
        return presenter;
    }
}
