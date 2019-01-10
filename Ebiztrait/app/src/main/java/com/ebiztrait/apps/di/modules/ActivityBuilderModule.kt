package com.ebiztrait.apps.di.modules

import com.ebiztrait.apps.di.annotations.ActivityScope
import com.ebiztrait.apps.views.main.MainActivity
import com.ebiztrait.apps.views.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Contains all activities to be bound to application dependency graph
 *
 * Created by ebiztrait on 11/01/18.
 */
@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity
}