package com.tushar.imdbmovie

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tushar.imdbmovie.adapter.MovieAdapter
import com.tushar.imdbmovie.adapter.MovieAdapter.PlaylistCallback
import com.tushar.imdbmovie.databinding.ActivityMainBinding
import com.tushar.imdbmovie.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), PlaylistCallback {
  private lateinit var binding: ActivityMainBinding
  private val viewModel: MovieViewModel by viewModels()
  private lateinit var movieAdapter: MovieAdapter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    supportActionBar?.hide()
    setUpRecyclerView()
  }

  private fun setUpRecyclerView() {
    movieAdapter = MovieAdapter()
    movieAdapter.setOnItemClickListener(this)
    binding.recyclerView.apply {
      adapter = movieAdapter
      layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
      setHasFixedSize(true)
    }

    viewModel.response.observe(this) { movies ->
      movieAdapter.list = movies
    }
  }

  override fun onItemClicked() {
    invokeBottomSheet()
  }

  private fun invokeBottomSheet() {
    val blankFragment = BottomSheetFragment()
    blankFragment.show(supportFragmentManager, blankFragment.getTag())

  }


}
