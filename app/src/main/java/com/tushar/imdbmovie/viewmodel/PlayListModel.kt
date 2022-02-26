package com.tushar.imdbmovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tushar.imdbmovie.repository.PlayListDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlayListModel constructor(private val repository: PlayListDB): ViewModel(){

  private val _response = MutableLiveData<List<String>>()
  val response : LiveData<List<String>>
    get() = _response

}