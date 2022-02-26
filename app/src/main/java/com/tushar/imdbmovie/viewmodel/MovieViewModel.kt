package com.tushar.imdbmovie.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tushar.imdbmovie.models.Movie
import com.tushar.imdbmovie.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository):ViewModel(){

  private val _response = MutableLiveData<List<Movie>>()
  val response : LiveData<List<Movie>>
    get() = _response

  init {
    getAllTvShows()
  }

  private fun getAllTvShows() = viewModelScope.launch {
    repository.getTvShows().let {response ->
      if (response.isSuccessful){
        _response.postValue(response.body()?.results)
      }else{
        Log.d("getAllTvShows ",response.code().toString())
      }
    }
  }

}