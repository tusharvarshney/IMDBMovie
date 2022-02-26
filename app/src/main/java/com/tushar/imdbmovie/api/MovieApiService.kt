package com.tushar.imdbmovie.api

import com.tushar.imdbmovie.helper.Constants
import com.tushar.imdbmovie.models.IMDBMovieReponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiService {

  @GET(Constants.END_POINT)
  suspend fun getMovies(): Response<IMDBMovieReponse>
}