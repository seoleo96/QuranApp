package com.example.quranapp.ui.contents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.R

class ContentAdapter : RecyclerView.Adapter<ContentAdapter.ContentViewHolder>() {

    private val listUIState = arrayListOf<ContentUiState>()
    private var contentId = 0
    private var size = 0
    fun updateList(list: List<ContentUiState>, contentId: Int) {
        this.contentId = contentId
        listUIState.clear()
        listUIState.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (listUIState[position]) {
            is ContentUiState.Fail -> 0
            is ContentUiState.Base -> 1
            is ContentUiState.Progress -> 2
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ContentViewHolder {
        return when (viewType) {
            0 -> ContentViewHolder.Fail(R.layout.chapters_row.makeView(parent))
            1 -> ContentViewHolder.Base(R.layout.chapters_row.makeView(parent), contentId, listUIState)
            else -> ContentViewHolder.FullscreenProgress(R.layout.progress_row.makeView(parent))

        }

    }

    private fun Int.makeView(parent: ViewGroup) =
        LayoutInflater.from(parent.context).inflate(this, parent, false)

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(listUIState[position])
    }


    override fun getItemCount(): Int {
        return listUIState.size
    }


    abstract class ContentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        open fun bind(uiState: ContentUiState) {
        }

        class FullscreenProgress(view: View) : ContentViewHolder(view)

        class Base(view: View, private val contentId: Int, val listUIState: ArrayList<ContentUiState>) : ContentViewHolder(view) {
            private val name = itemView.findViewById<TextView>(R.id.name)
            private val constraint = itemView.findViewById<TextView>(R.id.constraint)
            override fun bind(book: ContentUiState) {
                book.map(object : ContentUiState.StringMapper {
                    override fun map(text: String, id : Int) {
                        if (contentId == id){
                            name.text = text.toString()
                        }else{
                            name.height = 0
                        }
                    }
                })
            }
        }

        class Fail(view: View) : ContentViewHolder(view) {
            private val message = itemView.findViewById<TextView>(R.id.name)
            override fun bind(book: ContentUiState) {
                book.map(object : ContentUiState.StringMapper {
                    override fun map(text: String, id : Int) {
                        message.text = text
                    }
                })

            }
        }
    }
}
