package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.MVP_Function;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Function_Module_ProvidedPresenterOpsFactory
    implements Factory<MVP_Function.ProvidedPresenterOps> {
  private final Function_Module module;

  public Function_Module_ProvidedPresenterOpsFactory(Function_Module module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public MVP_Function.ProvidedPresenterOps get() {
    return Preconditions.checkNotNull(
        module.providedPresenterOps(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<MVP_Function.ProvidedPresenterOps> create(Function_Module module) {
    return new Function_Module_ProvidedPresenterOpsFactory(module);
  }
}
