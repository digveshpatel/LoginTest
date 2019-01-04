package test.app.com.logintest.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import test.app.com.logintest.presentation.login.LoginActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun provideLoginActivity(): LoginActivity

}