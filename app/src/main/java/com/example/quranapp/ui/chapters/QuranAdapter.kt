package com.example.quranapp.ui.chapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.R

class QuranAdapter(val itemClickListener: (id : Int) -> Unit) :
    RecyclerView.Adapter<QuranAdapter.QuranViewHolder>() {

    private val listUIState = arrayListOf<QuranUiState>()
    fun updateList(list: List<QuranUiState>) {
        listUIState.clear()
        listUIState.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (listUIState[position]) {
            is QuranUiState.Fail -> 0
            is QuranUiState.Base -> 1
            is QuranUiState.Progress -> 2
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): QuranViewHolder {
        return when (viewType) {
            0 -> QuranViewHolder.Fail(R.layout.chapters_row.makeView(parent))
            1 -> QuranViewHolder.Base(R.layout.chapters_row.makeView(parent),itemClickListener )
            else -> QuranViewHolder.FullscreenProgress(R.layout.progress_row.makeView(parent))

        }

    }

    private fun Int.makeView(parent: ViewGroup) =
        LayoutInflater.from(parent.context).inflate(this, parent, false)

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        holder.bind(listUIState[position])
    }


    override fun getItemCount(): Int {
        return listUIState.size
    }


    abstract class QuranViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        open fun bind(uiState: QuranUiState) {

        }

        class FullscreenProgress(view: View) : QuranViewHolder(view)

        class Base(view: View, private val itemClickListener: (id : Int) -> Unit) : QuranViewHolder(view) {
            private val name = itemView.findViewById<TextView>(R.id.name)
            private val contentInfo = itemView.findViewById<ConstraintLayout>(R.id.content)
            override fun bind(book: QuranUiState) {
                book.map(object : QuranUiState.StringMapper {
                    override fun map(text: String, id: Int) {
                        name.text = text
                        contentInfo.setOnClickListener {
                            itemClickListener.invoke(id)
                        }
                    }
                })
            }
        }

        class Fail(view: View) : QuranViewHolder(view) {
            private val message = itemView.findViewById<TextView>(R.id.name)
            override fun bind(uiState: QuranUiState) {
                uiState.map(object : QuranUiState.StringMapper {
                    override fun map(text: String, id: Int) {
                        message.text = id.toString()

                    }
                })

            }
        }
    }
}

interface ItemClickListener {
    fun onClick(id: Int)
}
