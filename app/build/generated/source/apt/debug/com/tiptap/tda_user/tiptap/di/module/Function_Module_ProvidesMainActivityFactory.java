package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.main.activity.view.function.Function;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Function_Module_ProvidesMainActivityFactory implements Factory<Function> {
  private final Function_Module module;

  public Function_Module_ProvidesMainActivityFactory(Function_Module module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Function get() {
    return Preconditions.checkNotNull(
        module.providesMainActivity(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Function> create(Function_Module module) {
    return new Function_Module_ProvidesMainActivityFactory(module);
  }
}
