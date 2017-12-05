package com.tiptap.tda_user.tiptap.di.component;

import android.app.Application;
import com.tiptap.tda_user.tiptap.MVP_Function;
import com.tiptap.tda_user.tiptap.MVP_Language;
import com.tiptap.tda_user.tiptap.MVP_Lesson;
import com.tiptap.tda_user.tiptap.MVP_Splash;
import com.tiptap.tda_user.tiptap.di.module.AppModule;
import com.tiptap.tda_user.tiptap.di.module.AppModule_ProvidesApplicationFactory;
import com.tiptap.tda_user.tiptap.di.module.Function_Module;
import com.tiptap.tda_user.tiptap.di.module.Function_Module_ProvidedPresenterOpsFactory;
import com.tiptap.tda_user.tiptap.di.module.Language_Module;
import com.tiptap.tda_user.tiptap.di.module.Language_Module_ProvidedPresenterOpsFactory;
import com.tiptap.tda_user.tiptap.di.module.Lesson_Module;
import com.tiptap.tda_user.tiptap.di.module.Lesson_Module_ProvidedPresenterOpsFactory;
import com.tiptap.tda_user.tiptap.di.module.Splash_Module;
import com.tiptap.tda_user.tiptap.di.module.Splash_Module_ProvidedPresenterOpsFactory;
import com.tiptap.tda_user.tiptap.main.activity.view.function.Function;
import com.tiptap.tda_user.tiptap.main.activity.view.function.Function_MembersInjector;
import com.tiptap.tda_user.tiptap.main.activity.view.language.Language;
import com.tiptap.tda_user.tiptap.main.activity.view.language.Language_MembersInjector;
import com.tiptap.tda_user.tiptap.main.activity.view.lesson.Lesson;
import com.tiptap.tda_user.tiptap.main.activity.view.lesson.Lesson_MembersInjector;
import com.tiptap.tda_user.tiptap.main.activity.view.splash.Splash;
import com.tiptap.tda_user.tiptap.main.activity.view.splash.Splash_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<Application> providesApplicationProvider;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.providesApplicationProvider =
        DoubleCheck.provider(AppModule_ProvidesApplicationFactory.create(builder.appModule));
  }

  @Override
  public Application application() {
    return providesApplicationProvider.get();
  }

  @Override
  public Function_Component getFunctionComponent(Function_Module module) {
    return new Function_ComponentImpl(module);
  }

  @Override
  public Lesson_Component getLessonComponent(Lesson_Module module) {
    return new Lesson_ComponentImpl(module);
  }

  @Override
  public Language_Component getLanguageComponent(Language_Module module) {
    return new Language_ComponentImpl(module);
  }

  @Override
  public Splash_Component getSplashComponent(Splash_Module module) {
    return new Splash_ComponentImpl(module);
  }

  public static final class Builder {
    private AppModule appModule;

    private Builder() {}

    public AppComponent build() {
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }
  }

  private final class Function_ComponentImpl implements Function_Component {
    private final Function_Module function_Module;

    private Provider<MVP_Function.ProvidedPresenterOps> providedPresenterOpsProvider;

    private MembersInjector<Function> functionMembersInjector;

    private Function_ComponentImpl(Function_Module function_Module) {
      this.function_Module = Preconditions.checkNotNull(function_Module);
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.providedPresenterOpsProvider =
          DoubleCheck.provider(Function_Module_ProvidedPresenterOpsFactory.create(function_Module));

      this.functionMembersInjector = Function_MembersInjector.create(providedPresenterOpsProvider);
    }

    @Override
    public Function inject(Function activity) {
      functionMembersInjector.injectMembers(activity);
      return activity;
    }
  }

  private final class Lesson_ComponentImpl implements Lesson_Component {
    private final Lesson_Module lesson_Module;

    private Provider<MVP_Lesson.ProvidedPresenterOps> providedPresenterOpsProvider;

    private MembersInjector<Lesson> lessonMembersInjector;

    private Lesson_ComponentImpl(Lesson_Module lesson_Module) {
      this.lesson_Module = Preconditions.checkNotNull(lesson_Module);
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.providedPresenterOpsProvider =
          DoubleCheck.provider(Lesson_Module_ProvidedPresenterOpsFactory.create(lesson_Module));

      this.lessonMembersInjector = Lesson_MembersInjector.create(providedPresenterOpsProvider);
    }

    @Override
    public Lesson inject(Lesson activity) {
      lessonMembersInjector.injectMembers(activity);
      return activity;
    }
  }

  private final class Language_ComponentImpl implements Language_Component {
    private final Language_Module language_Module;

    private Provider<MVP_Language.ProvidedPresenterOps> providedPresenterOpsProvider;

    private MembersInjector<Language> languageMembersInjector;

    private Language_ComponentImpl(Language_Module language_Module) {
      this.language_Module = Preconditions.checkNotNull(language_Module);
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.providedPresenterOpsProvider =
          DoubleCheck.provider(Language_Module_ProvidedPresenterOpsFactory.create(language_Module));

      this.languageMembersInjector = Language_MembersInjector.create(providedPresenterOpsProvider);
    }

    @Override
    public Language inject(Language activity) {
      languageMembersInjector.injectMembers(activity);
      return activity;
    }
  }

  private final class Splash_ComponentImpl implements Splash_Component {
    private final Splash_Module splash_Module;

    private Provider<MVP_Splash.ProvidedPresenterOps> providedPresenterOpsProvider;

    private MembersInjector<Splash> splashMembersInjector;

    private Splash_ComponentImpl(Splash_Module splash_Module) {
      this.splash_Module = Preconditions.checkNotNull(splash_Module);
      initialize();
    }

    @SuppressWarnings("unchecked")
    private void initialize() {

      this.providedPresenterOpsProvider =
          DoubleCheck.provider(Splash_Module_ProvidedPresenterOpsFactory.create(splash_Module));

      this.splashMembersInjector = Splash_MembersInjector.create(providedPresenterOpsProvider);
    }

    @Override
    public Splash inject(Splash activity) {
      splashMembersInjector.injectMembers(activity);
      return activity;
    }
  }
}
