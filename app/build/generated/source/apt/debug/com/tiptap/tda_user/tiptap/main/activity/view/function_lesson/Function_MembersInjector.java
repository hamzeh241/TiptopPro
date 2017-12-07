package com.tiptap.tda_user.tiptap.main.activity.view.function_lesson;

import com.tiptap.tda_user.tiptap.MVP_Function;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Function_MembersInjector implements MembersInjector<Function> {
  private final Provider<MVP_Function.ProvidedPresenterOps> mPresenterProvider;

  public Function_MembersInjector(Provider<MVP_Function.ProvidedPresenterOps> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<Function> create(
      Provider<MVP_Function.ProvidedPresenterOps> mPresenterProvider) {
    return new Function_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(Function instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }
}
