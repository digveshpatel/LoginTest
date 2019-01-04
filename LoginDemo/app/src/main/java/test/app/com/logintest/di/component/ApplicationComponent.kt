package test.app.com.logintest.di.component


import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import test.app.com.logintest.LoginApplication
import test.app.com.logintest.di.module.ActivityModule
import test.app.com.logintest.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, ApplicationModule::class, ActivityModule::class))
interface ApplicationComponent {

    fun inject(application: LoginApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

}