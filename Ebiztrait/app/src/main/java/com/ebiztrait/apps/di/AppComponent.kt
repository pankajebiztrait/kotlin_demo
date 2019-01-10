package com.ebiztrait.apps.di

import com.ebiztrait.apps.MyApplication
import com.ebiztrait.apps.di.annotations.ApplicationScope
import com.ebiztrait.apps.di.modules.ActivityBuilderModule
import com.ebiztrait.apps.di.modules.AppModule
import com.ebiztrait.apps.di.modules.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Main application component that connects all the dependency providers(modules) to application
 *
 * Created by ebiztrait on 11/01/18.
 */
@ApplicationScope
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        ActivityBuilderModule::class))
interface AppComponent: AndroidInjector<MyApplication> {

    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<MyApplication>()
}