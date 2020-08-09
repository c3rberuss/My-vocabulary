package com.c3rberuss.myvocabulary.presentation.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.c3rberuss.core.domain.Verb
import com.c3rberuss.myvocabulary.R

class VerbsListAdapter(private val context: Context) : ListAdapter<Verb, VerbsListAdapter.VerbViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerbViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.verb_item, parent, false)
        return VerbViewHolder(view)
    }

    override fun onBindViewHolder(holder: VerbViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VerbViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(verb: Verb){
            view.findViewById<TextView>(R.id.verb_name).text = verb.baseForm
        }
    }
}

private class DiffCallback: DiffUtil.ItemCallback<Verb>() {
    override fun areItemsTheSame(oldItem: Verb, newItem: Verb): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Verb, newItem: Verb): Boolean {
        return oldItem == newItem
    }
}