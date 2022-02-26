package com.tushar.imdbmovie.repository

import com.tushar.imdbmovie.api.MovieApiService
import javax.inject.Inject

class MovieRepository
@Inject
constructor(private val apiService: MovieApiService) {
  suspend fun getTvShows() = apiService.getMovies()
}