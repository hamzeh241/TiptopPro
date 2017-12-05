package com.tiptap.tda_user.tiptap.main.activity.view.splash;

import com.tiptap.tda_user.tiptap.MVP_Splash;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Splash_MembersInjector implements MembersInjector<Splash> {
  private final Provider<MVP_Splash.ProvidedPresenterOps> mPresenterProvider;

  public Splash_MembersInjector(Provider<MVP_Splash.ProvidedPresenterOps> mPresenterProvider) {
    assert mPresenterProvider != null;
    this.mPresenterProvider = mPresenterProvider;
  }

  public static MembersInjector<Splash> create(
      Provider<MVP_Splash.ProvidedPresenterOps> mPresenterProvider) {
    return new Splash_MembersInjector(mPresenterProvider);
  }

  @Override
  public void injectMembers(Splash instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mPresenter = mPresenterProvider.get();
  }
}
