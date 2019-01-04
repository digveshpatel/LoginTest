package test.app.com.logintest.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import test.app.com.logintest.data.LoginDataRepository
import test.app.com.logintest.domain.repository.LoginRepository

import javax.inject.Singleton

@Module(includes = arrayOf(ViewModelModule::class))
class ApplicationModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    //Gson injection
    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun  provideLoginRepository(loginDataRepository: LoginDataRepository): LoginRepository
    {
        return loginDataRepository;
    }
}