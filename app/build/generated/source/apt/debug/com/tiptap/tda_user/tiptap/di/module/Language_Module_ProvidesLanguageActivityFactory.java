package com.tiptap.tda_user.tiptap.di.module;

import com.tiptap.tda_user.tiptap.main.activity.view.language.Language;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Language_Module_ProvidesLanguageActivityFactory implements Factory<Language> {
  private final Language_Module module;

  public Language_Module_ProvidesLanguageActivityFactory(Language_Module module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Language get() {
    return Preconditions.checkNotNull(
        module.providesLanguageActivity(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Language> create(Language_Module module) {
    return new Language_Module_ProvidesLanguageActivityFactory(module);
  }
}
