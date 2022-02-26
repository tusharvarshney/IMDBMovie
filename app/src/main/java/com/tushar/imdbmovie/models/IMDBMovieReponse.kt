package com.tushar.imdbmovie.models

data class IMDBMovieReponse(
    val dates: Dates,
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)