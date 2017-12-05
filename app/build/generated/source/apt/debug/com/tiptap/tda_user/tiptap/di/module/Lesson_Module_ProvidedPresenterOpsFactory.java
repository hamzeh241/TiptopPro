package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.MVP_Lesson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Lesson_Module_ProvidedPresenterOpsFactory
    implements Factory<MVP_Lesson.ProvidedPresenterOps> {
  private final Lesson_Module module;

  public Lesson_Module_ProvidedPresenterOpsFactory(Lesson_Module module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public MVP_Lesson.ProvidedPresenterOps get() {
    return Preconditions.checkNotNull(
        module.providedPresenterOps(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MVP_Lesson.ProvidedPresenterOps> create(Lesson_Module module) {
    return new Lesson_Module_ProvidedPresenterOpsFactory(module);
  }
}
