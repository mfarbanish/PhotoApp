package com.mahlon.photoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import com.mahlon.photoapp.Repository.UnsplashRepository
import com.mahlon.photoapp.fragments.ScrollFeedFragment
import com.mahlon.photoapp.viewmodel.ScrollFeedViewModel
import com.mahlon.photoapp.viewmodel.ScrollFeedViewModelFactory

class PhotoScrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_scroll_activity)

        val repo = UnsplashRepository()
        val viewModelFactory = ScrollFeedViewModelFactory(repo)
        val viewModel = ViewModelProvider(this, viewModelFactory)[ScrollFeedViewModel::class.java]
        val feedFragment = ScrollFeedFragment(viewModel)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, feedFragment)
            .commit()
    }
}