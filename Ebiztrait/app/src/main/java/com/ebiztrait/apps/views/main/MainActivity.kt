package com.ebiztrait.apps.views.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ebiztrait.apps.R
import com.ebiztrait.apps.common.BaseActivity
import com.ebiztrait.apps.views.main.helper.RepoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var mainViewModel: MainViewModel

    lateinit var mRepoAdapter: RepoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        /* observeLoader(mainViewModel, loaderView)

        observeSearchResults()*/

        //init a query
        observeSearchResults()

        mainViewModel.start("android")
        srl_container.setOnRefreshListener {
            mainViewModel.onRefresh()
        }
    }

    private fun initViews() {
        mRepoAdapter = RepoAdapter()
        mRepoAdapter.onLoadMoreListener = object : RepoAdapter.OnLoadMoreListener {
            override fun onLoadMore() {
                mainViewModel.onLoadMore()
            }
        }
        rv_content.adapter = mRepoAdapter
        rv_content.layoutManager = LinearLayoutManager(this)
    }

    private fun observeSearchResults() {
        mainViewModel.repoList.observe(this, Observer {
            /*Timber.i("repo count received  ${it?.size}")*/
            if (it?.page == 1) mRepoAdapter.resetItems(it?.repoList)
            else mRepoAdapter.addItems(it?.repoList)
        })

        mainViewModel.loader.observe(this, Observer {
            if (it == false) srl_container.isRefreshing = false

            if (it == true && !srl_container.isRefreshing)
                pb_loading.visibility = View.VISIBLE
            else
                pb_loading.visibility = View.GONE
        })
    }
}
