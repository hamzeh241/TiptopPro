package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.main.activity.view.splash.Splash;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Splash_Module_ProvidesSplashActivityFactory implements Factory<Splash> {
  private final Splash_Module module;

  public Splash_Module_ProvidesSplashActivityFactory(Splash_Module module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Splash get() {
    return Preconditions.checkNotNull(
        module.providesSplashActivity(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Splash> create(Splash_Module module) {
    return new Splash_Module_ProvidesSplashActivityFactory(module);
  }
}
