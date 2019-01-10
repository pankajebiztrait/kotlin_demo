package com.ebiztrait.apps

import com.ebiztrait.apps.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

/**
 * Application class that initiates the dependency graph
 *
 * Created by ebiztrait on 11/01/18.
 */
class MyApplication: DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
//dragger application inject here
    override fun applicationInjector(): AndroidInjector<out MyApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}