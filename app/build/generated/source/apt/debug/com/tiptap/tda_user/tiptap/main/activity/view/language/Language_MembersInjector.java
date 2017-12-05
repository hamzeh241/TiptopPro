package com.tiptap.tda_user.tiptap.main.activity.view.language;

import com.tiptap.tda_user.tiptap.MVP_Language;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Language_MembersInjector implements MembersInjector<Language> {
  private final Provider<MVP_Language.ProvidedPresenterOps> mPresenterProvider;

  public Language_MembersInjector(Provider<MVP_Language.ProvidedPresenterOps> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<Language> create(
      Provider<MVP_Language.ProvidedPresenterOps> mPresenterProvider) {
    return new Language_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(Language instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }
}
