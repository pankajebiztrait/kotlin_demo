package com.ebiztrait.apps.di.modules

import com.ebiztrait.apps.data.services.GithubService
import com.ebiztrait.apps.di.annotations.ApplicationScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Provides network services for data
 *
 * Created by ebiztrait on 16/01/18.
 */
@Module(includes = arrayOf(NetworkModule::class))
class NetworkServiceModule {

    @Provides
    @ApplicationScope
    fun provideGithubService(retrofit: Retrofit): GithubService{
        return retrofit.create(GithubService::class.java)
    }
}