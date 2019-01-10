package com.ebiztrait.apps.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.ebiztrait.apps.common.ViewModelFactory
import com.ebiztrait.apps.di.annotations.ViewModelKey
import com.ebiztrait.apps.views.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Provides map of all ViewModels and a ViewModelFactory for dependencies
 *
 * Created by ebiztrait on 11/01/18.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}