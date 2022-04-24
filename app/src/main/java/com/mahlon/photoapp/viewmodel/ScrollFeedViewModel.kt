package com.mahlon.photoapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahlon.photoapp.Repository.UnsplashRepository
import com.mahlon.photoapp.modal.UnsplashResponseItem
import kotlinx.coroutines.launch

class ScrollFeedViewModel(val repo: UnsplashRepository): ViewModel() {
    val data : MutableLiveData<List<UnsplashResponseItem>> = MutableLiveData()

    init {
        getData()
    }

    private fun getData() = viewModelScope.launch {
        val response = repo.getImage(1)
        if (response.isSuccessful) {
            data.postValue(response.body())
            Log.i(tag, "response is a success")
            Log.i(tag, response.body().toString())
        } else {
            Log.i(tag, "response is a failure")
        }
    }
    companion object {
        val tag = ScrollFeedViewModel::class.java.canonicalName
    }
}