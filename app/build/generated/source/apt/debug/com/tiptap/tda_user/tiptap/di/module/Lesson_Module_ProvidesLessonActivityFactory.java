package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.main.activity.view.lesson.Lesson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Lesson_Module_ProvidesLessonActivityFactory implements Factory<Lesson> {
  private final Lesson_Module module;

  public Lesson_Module_ProvidesLessonActivityFactory(Lesson_Module module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Lesson get() {
    return Preconditions.checkNotNull(
        module.providesLessonActivity(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Lesson> create(Lesson_Module module) {
    return new Lesson_Module_ProvidesLessonActivityFactory(module);
  }
}
