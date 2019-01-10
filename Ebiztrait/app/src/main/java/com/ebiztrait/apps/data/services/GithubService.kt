package com.ebiztrait.apps.data.services

import com.ebiztrait.apps.data.models.RepoSearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 */
interface GithubService {

    @GET("search/repositories")
    fun searchRepos(@Query("q") query: String,
                    @Query("page") page : Int,
                    @Query("per_page") perPage : Int): Observable<RepoSearchResponse>
}