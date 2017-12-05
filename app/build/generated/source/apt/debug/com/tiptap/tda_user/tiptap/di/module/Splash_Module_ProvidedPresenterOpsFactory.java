package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.MVP_Splash;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Splash_Module_ProvidedPresenterOpsFactory
    implements Factory<MVP_Splash.ProvidedPresenterOps> {
  private final Splash_Module module;

  public Splash_Module_ProvidedPresenterOpsFactory(Splash_Module module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public MVP_Splash.ProvidedPresenterOps get() {
    return Preconditions.checkNotNull(
        module.providedPresenterOps(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MVP_Splash.ProvidedPresenterOps> create(Splash_Module module) {
    return new Splash_Module_ProvidedPresenterOpsFactory(module);
  }
}
