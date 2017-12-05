package com.tiptap.tda_user.tiptap.main.activity.view.lesson;

import com.tiptap.tda_user.tiptap.MVP_Lesson;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Lesson_MembersInjector implements MembersInjector<Lesson> {
  private final Provider<MVP_Lesson.ProvidedPresenterOps> mPresenterProvider;

  public Lesson_MembersInjector(Provider<MVP_Lesson.ProvidedPresenterOps> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<Lesson> create(
      Provider<MVP_Lesson.ProvidedPresenterOps> mPresenterProvider) {
    return new Lesson_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(Lesson instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }
}
