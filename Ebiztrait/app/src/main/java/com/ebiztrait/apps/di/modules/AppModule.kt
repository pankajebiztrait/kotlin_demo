package com.ebiztrait.apps.di.modules

import android.app.Application
import android.content.Context
import com.ebiztrait.apps.di.annotations.ApplicationScope
import dagger.Module
import dagger.Provides

/**
 * App level dependencies
 * Created by ebiztrait on 11/01/18.
 */
@Module(includes = arrayOf(NetworkServiceModule::class))
class AppModule {

    @Provides
    @ApplicationScope
    fun provideContext(application: Application): Context = application
}