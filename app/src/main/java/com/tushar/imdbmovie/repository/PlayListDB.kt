package com.tushar.imdbmovie.repository

class PlayListDB {

  suspend fun getPlayListAvailable():List<String> {
    val playList:ArrayList<String> = ArrayList()
    playList.add("playlist 1")
    playList.add("playlist 2")
    playList.add("playlist 3")
    return playList
  }
}