package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.MVP_Language;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Language_Module_ProvidedPresenterOpsFactory
    implements Factory<MVP_Language.ProvidedPresenterOps> {
  private final Language_Module module;

  public Language_Module_ProvidedPresenterOpsFactory(Language_Module module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public MVP_Language.ProvidedPresenterOps get() {
    return Preconditions.checkNotNull(
        module.providedPresenterOps(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MVP_Language.ProvidedPresenterOps> create(Language_Module module) {
    return new Language_Module_ProvidedPresenterOpsFactory(module);
  }
}
