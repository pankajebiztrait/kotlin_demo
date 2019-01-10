package com.ebiztrait.apps.views.main

import android.arch.lifecycle.MutableLiveData
import com.ebiztrait.apps.common.BaseViewModel
import com.ebiztrait.apps.common.network.ApiObserver
import com.ebiztrait.apps.data.models.ErrorData
import com.ebiztrait.apps.data.models.RepoDTO
import com.ebiztrait.apps.data.models.RepoSearchResponse
import com.ebiztrait.apps.data.repository.DataRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by ebiztrait on 11/01/18.
 */
class MainViewModel @Inject constructor(private val dataRepository: DataRepository) : BaseViewModel() {

    private var msg: String = "test"

    var repoList: MutableLiveData<RepoDTOWrapper> = MutableLiveData()


    private var currentPage = 1
    private var perPage = 20
    private var query : String = ""

    fun getMessage(): String {
        msg = dataRepository.getMessage()
        return msg
    }


        fun start(query: String){
            currentPage = 1
            this.query = query
            searchRepos()
        }

        fun onLoadMore(){
            currentPage++
            searchRepos()
        }

        fun onRefresh(){
            currentPage = 1
            searchRepos()
        }

        fun searchRepos(){

            loader.value = true

            dataRepository.searchRepositories(query)
            dataRepository.searchRepositories(query,currentPage,perPage)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : ApiObserver<RepoSearchResponse>(compositeDisposable) {
                        override fun onError(e: ErrorData) {
                            displayLoader(false)
                            loader.value = false
                            error.value = e
                        }

                        override fun onSuccess(data: RepoSearchResponse) {
                            displayLoader(false)
                            //repoList.value = data.repoList
                            loader.value = false
                            repoList.value = RepoDTOWrapper(data.repoList,currentPage)
                        }
                    })
        }
    }




data class RepoDTOWrapper(
        var repoList : List<RepoDTO>,
        var page : Int
)