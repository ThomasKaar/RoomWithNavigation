package at.htl.roomwithnavigation.ui.main

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import at.htl.roomwithnavigation.R
import at.htl.roomwithnavigation.R.id.action_mainFragment_to_updateFragment
import at.htl.roomwithnavigation.entities.Word
import kotlinx.android.synthetic.main.content_item.view.*


class WordListAdapter(var list: List<Word> = listOf()) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.content_item, parent, false)
        return WordViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current: Word = list[position]
        holder.view.textView.text = "${current.id}: ${current.word}"
        holder.view.setOnClickListener {
            var bundle = Bundle()
            bundle.putLong("Id", current.id)
            bundle.putString("Word", current.word)
            Navigation.findNavController(it).navigate(action_mainFragment_to_updateFragment, bundle)
        }
    }

    class WordViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}