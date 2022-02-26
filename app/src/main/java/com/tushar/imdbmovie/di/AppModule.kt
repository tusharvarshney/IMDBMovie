package com.tushar.imdbmovie.di

import com.tushar.imdbmovie.api.MovieApiService
import com.tushar.imdbmovie.helper.Constants
import com.tushar.imdbmovie.repository.PlayListDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Provides
  fun provideBaseUrl() = Constants.BASE_URL

  @Provides
  @Singleton
  fun provideRetrofitInstance(baseUrl:String):MovieApiService =
    Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(MovieApiService::class.java)

}