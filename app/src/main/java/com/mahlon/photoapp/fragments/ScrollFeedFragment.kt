package com.mahlon.photoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahlon.photoapp.R
import com.mahlon.photoapp.viewmodel.ScrollFeedViewModel

class ScrollFeedFragment(private val viewModel: ScrollFeedViewModel): Fragment() {

    lateinit var feedRecylerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.scroll_feed_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        feedRecylerView = view.findViewById(R.id.scroll_feed_recycler)
        val photoScrollAdapter = PhotoScrollAdapter()
        feedRecylerView.adapter = photoScrollAdapter
        feedRecylerView.layoutManager = LinearLayoutManager(context)

        viewModel.data.observe(
            viewLifecycleOwner
        ) { dataResponse, ->
            dataResponse?.let { photoScrollAdapter.listDiffer.submitList(dataResponse) }
        }
        super.onViewCreated(view, savedInstanceState)
    }

}