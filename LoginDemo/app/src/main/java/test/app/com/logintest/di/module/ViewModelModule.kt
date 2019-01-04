package test.app.com.logintest.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import test.app.com.logintest.di.key.ViewModelKey
import test.app.com.logintest.presentation.base.ViewModelFactory
import test.app.com.logintest.presentation.login.LoginViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModule(loginViewModel: LoginViewModel): ViewModel

}