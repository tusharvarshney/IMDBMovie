package com.tushar.imdbmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tushar.imdbmovie.adapter.PlayListAdapter.MyViewHolder
import com.tushar.imdbmovie.databinding.PlaylistItemBinding

class PlayListAdapter : RecyclerView.Adapter<MyViewHolder>() {
  inner class MyViewHolder(val binding: PlaylistItemBinding) : RecyclerView.ViewHolder(binding.root)

  interface PlaylistItemCallback {
    fun onItemClicked()
  }

  private var listener: PlaylistItemCallback? = null

  fun setOnItemClickListener(callback: PlaylistItemCallback) {
    listener = callback
  }

  private val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
      return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
      return oldItem == newItem
    }

  })

  var list: List<String>
    get() = differ.currentList
    set(value) {
      differ.submitList(value)
    }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    return MyViewHolder(PlaylistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    val current = list[position]
    holder.binding.apply {
        textView.text = current
    }
    }

  override fun getItemCount(): Int {
    return list.size
  }
}