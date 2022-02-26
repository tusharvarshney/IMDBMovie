package com.tushar.imdbmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.tushar.imdbmovie.adapter.MovieAdapter.MyViewHolder
import com.tushar.imdbmovie.databinding.MovieItemBinding
import com.tushar.imdbmovie.helper.Constants.IMAGE_BASE_PATH
import com.tushar.imdbmovie.models.Movie

class MovieAdapter : RecyclerView.Adapter<MyViewHolder>() {
  inner class MyViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

  interface PlaylistCallback {
    fun onItemClicked()
  }

  private var listener: PlaylistCallback? = null

  fun setOnItemClickListener(callback: PlaylistCallback) {
    listener = callback
  }

  private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
      return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
      return oldItem == newItem
    }

  })

  var list: List<Movie>
    get() = differ.currentList
    set(value) {
      differ.submitList(value)
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    return MyViewHolder(MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val current = list[position]
    holder.binding.apply {
      imageView.load(IMAGE_BASE_PATH + current.poster_path) {
        crossfade(true)
        crossfade(5000)
        title.text = current.title
        rating.text = current.vote_average.toString()
        starButton.setOnClickListener {
          listener?.onItemClicked()
        }
      }
    }
  }

  override fun getItemCount(): Int {
    return list.size
  }

}