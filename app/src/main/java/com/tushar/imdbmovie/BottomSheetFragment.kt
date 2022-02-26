package com.tushar.imdbmovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.tushar.imdbmovie.adapter.PlayListAdapter
import com.tushar.imdbmovie.repository.PlayListDB
import com.tushar.imdbmovie.viewmodel.PlayListModel

class BottomSheetFragment : BottomSheetDialogFragment() {
  private val viewModel: PlayListModel = PlayListModel(PlayListDB())

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view:View =  inflater.inflate(R.layout.bottom_sheet_dialog_layout, container, false)

    val button = view.findViewById<View>(R.id.button)
    button.setOnClickListener {
      Toast.makeText(this.context,"Add Playlist",Toast.LENGTH_SHORT).show();
    }

    val playListAdapter = PlayListAdapter()

    val recyclerView:RecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView2)
    recyclerView.adapter = playListAdapter
    recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
    recyclerView.setHasFixedSize(true)

    viewModel.response.observe(this) { playlist ->
      playListAdapter.list = playlist
    }

    return view
  }
}