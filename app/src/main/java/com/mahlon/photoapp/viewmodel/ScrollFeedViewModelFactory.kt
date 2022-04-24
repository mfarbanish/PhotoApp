package com.mahlon.photoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mahlon.photoapp.Repository.UnsplashRepository

class ScrollFeedViewModelFactory(private val repo: UnsplashRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ScrollFeedViewModel(repo) as T
    }
}