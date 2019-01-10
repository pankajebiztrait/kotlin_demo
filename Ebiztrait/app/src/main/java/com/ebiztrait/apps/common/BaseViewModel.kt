package com.ebiztrait.apps.common

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ebiztrait.apps.data.models.ErrorData
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by ebiztrait on 18/01/18.
 */
open class BaseViewModel: ViewModel() {

    val loader: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<ErrorData?> = MutableLiveData()
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
    fun displayLoader(isLoading: Boolean) {
        loader.value = isLoading
    }
}