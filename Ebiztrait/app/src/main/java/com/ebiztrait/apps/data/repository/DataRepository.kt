package com.ebiztrait.apps.data.repository

import com.ebiztrait.apps.data.models.RepoSearchResponse
import com.ebiztrait.apps.data.services.GithubService
import com.ebiztrait.apps.di.annotations.ApplicationScope
import io.reactivex.Observable
import javax.inject.Inject

/**
 *
 */
@ApplicationScope
class DataRepository @Inject constructor(private val githubService: GithubService) {

    fun getMessage(): String {
        return "hello my message"
    }

    fun searchRepositories(query: String,
                           page:Int=0,
                           per_page:Int=20): Observable<RepoSearchResponse> = githubService.searchRepos(query,page,per_page)

}